package org.jugular.core.api.annotation;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

/**
 *
 * @author Sharmarke Aden (saden1)
 */
@Documented
@Retention(RUNTIME)
@Target({CONSTRUCTOR, FIELD, METHOD})
public @interface Jugular {
}
