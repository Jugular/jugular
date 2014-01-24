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
package org.jugular.jodatime;

import java.lang.reflect.AnnotatedElement;
import javax.inject.Inject;
import javax.inject.Named;
import org.glassfish.hk2.api.Injectee;
import org.glassfish.hk2.api.InjectionResolver;
import static org.glassfish.hk2.api.InjectionResolver.SYSTEM_RESOLVER_NAME;
import org.glassfish.hk2.api.ServiceHandle;
import org.jugular.core.api.annotation.Jugular;
import org.jugular.jodatime.annotation.Joda;
import org.jvnet.hk2.annotations.Service;

/**
 *
 * @author Sharmarke Aden (saden1)
 */
@Service
public class DateTimeResolver implements InjectionResolver<Jugular> {

    private final InjectionResolver<Inject> resolver;

    @Inject
    DateTimeResolver(@Named(SYSTEM_RESOLVER_NAME) InjectionResolver<Inject> systemResolver) {
        this.resolver = systemResolver;
    }

    @Override
    public Object resolve(Injectee injectee, ServiceHandle<?> root) {
        AnnotatedElement parent = injectee.getParent();

        Joda joda = parent.getAnnotation(Joda.class);

        if (joda == null) {
            return resolver.resolve(injectee, root);
        }

        return resolver.resolve(injectee, root);
    }

    @Override
    public boolean isConstructorParameterIndicator() {
        return true;
    }

    @Override
    public boolean isMethodParameterIndicator() {
        return true;
    }
}
