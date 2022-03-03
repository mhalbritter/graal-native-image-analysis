package generator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import generator.model.ClassModel;
import generator.model.InvocationModel;
import generator.model.ReflectConfigModel;

/**
 * @author Moritz Halbritter
 */
class Generator {
	public static final int NUMBER_OF_CLASSES = 1;

	public static final int METHODS_PER_CLASS = 1;

	public static void main(String[] args) throws IOException, TemplateException {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
		cfg.setClassForTemplateLoading(Generator.class, "/templates");
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.DEBUG_HANDLER);
		cfg.setWrapUncheckedExceptions(true);
		cfg.setFallbackOnNullLoopVariable(false);
		cfg.setNumberFormat("computer");

		// generateClasses(cfg, Files.createTempDirectory("generator"));
		// printInvocation(cfg);
		// printReflectConfig(cfg, Path.of("/tmp/reflect-config.json"));
		printReflectIntrospectionConfig(cfg, Path.of("/tmp/reflect-config.json"));
	}

	private static void printReflectConfig(Configuration cfg, Path file) throws IOException, TemplateException {
		ReflectConfigModel model = new ReflectConfigModel(NUMBER_OF_CLASSES, METHODS_PER_CLASS);

		Template template = cfg.getTemplate("reflect-config.json.ftl");

		Writer writer;
		if (file == null) {
			writer = new PrintWriter(System.out);
		}
		else {
			writer = Files.newBufferedWriter(file);
		}

		template.process(Map.of("model", model), writer);
		writer.flush();
	}

	private static void printReflectIntrospectionConfig(Configuration cfg, Path file) throws IOException, TemplateException {
		ReflectConfigModel model = new ReflectConfigModel(NUMBER_OF_CLASSES, METHODS_PER_CLASS);

		Template template = cfg.getTemplate("reflect-config-introspection.json.ftl");

		Writer writer;
		if (file == null) {
			writer = new PrintWriter(System.out);
		}
		else {
			writer = Files.newBufferedWriter(file);
		}

		template.process(Map.of("model", model), writer);
		writer.flush();
	}

	private static void printInvocation(Configuration cfg) throws IOException, TemplateException {
		InvocationModel model = new InvocationModel(NUMBER_OF_CLASSES, METHODS_PER_CLASS);

		Template template = cfg.getTemplate("invocation.java.ftl");

		template.process(Map.of("model", model), new PrintWriter(System.out));
	}

	private static void generateClasses(Configuration cfg, Path baseDirectory) throws IOException, TemplateException {
		Template template = cfg.getTemplate("class.java.ftl");

		for (int i = 0; i < NUMBER_OF_CLASSES; i++) {
			Path file = baseDirectory.resolve(String.format("Class%d.java", i)).toAbsolutePath();

			ClassModel model = new ClassModel(i, METHODS_PER_CLASS);

			try (BufferedWriter writer = Files.newBufferedWriter(file)) {
				template.process(Map.of("model", model), writer);
			}
			System.out.println("Wrote file " + file);
		}
	}
}
