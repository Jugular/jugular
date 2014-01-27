/*
 * Copyright 2014 Jugular.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jugular.jodatime.resolver;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import javax.inject.Inject;
import javax.inject.Named;
import org.glassfish.hk2.api.Injectee;
import org.glassfish.hk2.api.ServiceHandle;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.jugular.core.api.JugularResolver;
import org.jugular.jodatime.JodaTimeController;
import org.jugular.jodatime.annotation.Joda;
import org.jugular.jodatime.annotation.Joda.Type;
import org.jugular.jodatime.factory.ChronologyFactory;
import org.jvnet.hk2.annotations.Service;

/**
 *
 * @author Sharmarke Aden (saden1)
 */
@Named("org.joda.time.DateTime")
@Service
public class DateTimeResolver implements JugularResolver<DateTime> {

    private final JodaTimeController controller;
    private final ChronologyFactory factory;

    @Inject
    DateTimeResolver(JodaTimeController controller, ChronologyFactory factory) {
        this.controller = controller;
        this.factory = factory;
    }

    @Override
    public DateTime resolve(Injectee injectee, ServiceHandle<?> root) {
        AnnotatedElement parent = injectee.getParent();
        int index = injectee.getPosition();
        Annotation[][] paramAnnotations;
        Annotation[] annotations = {};

        if (parent instanceof Constructor) {
            Constructor constructor = (Constructor) parent;
            paramAnnotations = constructor.getParameterAnnotations();
            annotations = paramAnnotations[index];
        } else if (parent instanceof Field) {
            Field field = (Field) parent;
            annotations = field.getDeclaredAnnotations();
        }

        Joda joda = getAnnotation(annotations, Joda.class);
        Chronology chronology = controller.getChronology();

        if (joda != null) {
            Type chrono = joda.chronology();
            chronology = factory.create(chrono, joda.zone());
        }

        return new DateTime(chronology);
    }

    private <T> T getAnnotation(Annotation[] annotations, Class<T> type) {
        for (Annotation annotation : annotations) {
            if (type.equals(annotation.annotationType())) {
                return (T) annotation;
            }
        }

        return null;
    }

}
