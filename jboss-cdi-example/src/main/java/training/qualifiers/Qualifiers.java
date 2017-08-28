package training.qualifiers;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import javax.inject.Qualifier;

public class Qualifiers {
	@Qualifier
	@Retention(RUNTIME)
	@Target({TYPE, METHOD, FIELD, PARAMETER})
	public @interface ExampleEntityManager {}
	
	
	@Qualifier
	@Retention(RUNTIME)
	@Target({TYPE, METHOD, FIELD, PARAMETER})
	public @interface TrainingEntityManager {}
	
	
}
