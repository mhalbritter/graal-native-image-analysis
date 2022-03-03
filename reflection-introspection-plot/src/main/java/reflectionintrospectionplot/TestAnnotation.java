package reflectionintrospectionplot;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * @author Moritz Halbritter
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { CONSTRUCTOR, METHOD, TYPE })
public @interface TestAnnotation {
	String value();
}
