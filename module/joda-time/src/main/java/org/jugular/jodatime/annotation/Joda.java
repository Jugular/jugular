package org.jugular.jodatime.annotation;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

/**
 *
 * @author Sharmarke Aden (saden1)
 */
@Retention(RUNTIME)
@Target({PARAMETER, FIELD})
@Documented
public @interface Joda {

    Type chronology() default Type.ISO;

    String zone() default "UTC";

    public static enum Type {

        ISO,
        GREGORIAN_JULIAN,
        GREGORIAN,
        JULIAN,
        COPTIC,
        ETHIOPIC,
        BUDDHIST,
        ISLAMIC

    }

}
