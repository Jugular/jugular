package org.jugular.jodatime.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Sharmarke Aden (saden1)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
@Documented
public @interface Joda {

    /**
     * The time zone
     *
     * @return the timezone o
     */
    String value() default "UTC";
}
