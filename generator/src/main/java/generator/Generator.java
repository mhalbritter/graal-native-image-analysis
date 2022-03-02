package generator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
	public static final int NUMBER_OF_CLASSES = 100;
	public static final int METHODS_PER_CLASS = 100;

	public static void main(String[] args) throws IOException, TemplateException {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
		cfg.setClassForTemplateLoading(Generator.class, "/templates");
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.DEBUG_HANDLER);
		cfg.setWrapUncheckedExceptions(true);
		cfg.setFallbackOnNullLoopVariable(false);

		generateClasses(cfg);
		printInvocation(cfg);
		// printReflectConfig(cfg);
	}

	private static void printReflectConfig(Configuration cfg) throws IOException, TemplateException {
		ReflectConfigModel model = new ReflectConfigModel(NUMBER_OF_CLASSES, METHODS_PER_CLASS);

		Template template = cfg.getTemplate("reflect-config.json.ftl");

		template.process(Map.of("model", model), new PrintWriter(System.out));
	}

	private static void printInvocation(Configuration cfg) throws IOException, TemplateException {
		InvocationModel model = new InvocationModel(NUMBER_OF_CLASSES, METHODS_PER_CLASS);

		Template template = cfg.getTemplate("invocation.java.ftl");

		template.process(Map.of("model", model), new PrintWriter(System.out));
	}

	private static void generateClasses(Configuration cfg) throws IOException, TemplateException {
		Path tempDirectory = Files.createTempDirectory("generator");

		Template template = cfg.getTemplate("class.java.ftl");

		for (int i = 0; i < NUMBER_OF_CLASSES; i++) {
			Path file = tempDirectory.resolve(String.format("Class%d.java", i)).toAbsolutePath();

			ClassModel model = new ClassModel(i, METHODS_PER_CLASS);

			try (BufferedWriter writer = Files.newBufferedWriter(file)) {
				template.process(Map.of("model", model), writer);
			}
			System.out.println("Wrote file " + file);
		}
	}
}