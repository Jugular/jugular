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
package org.jugular.core.api;

import java.lang.reflect.Type;
import javax.inject.Inject;
import javax.inject.Named;
import org.glassfish.hk2.api.Injectee;
import org.glassfish.hk2.api.InjectionResolver;
import static org.glassfish.hk2.api.InjectionResolver.SYSTEM_RESOLVER_NAME;
import org.glassfish.hk2.api.IterableProvider;
import org.glassfish.hk2.api.ServiceHandle;
import org.jugular.core.api.annotation.Jugular;
import org.jvnet.hk2.annotations.Service;

/**
 *
 * @author Sharmarke Aden (saden1)
 */
@Service
public class JugularInjectionResolver implements InjectionResolver<Jugular> {

    private final InjectionResolver<Inject> systemResolver;
    private final IterableProvider<JugularResolver> delegateResolvers;

    @Inject
    JugularInjectionResolver(
            @Named(SYSTEM_RESOLVER_NAME) InjectionResolver<Inject> systemResolver,
            IterableProvider<JugularResolver> delegateResolvers) {
        this.systemResolver = systemResolver;
        this.delegateResolvers = delegateResolvers;
    }

    @Override
    public Object resolve(Injectee injectee, ServiceHandle<?> root) {
        Type type = injectee.getRequiredType();

        if (type instanceof Class) {
            String className = ((Class) type).getCanonicalName();
            JugularResolver delegate = delegateResolvers.named(className)
                    .get();

            if (delegate != null) {
                return delegate.resolve(injectee, root);
            }

        }
        return systemResolver.resolve(injectee, root);
    }

    @Override
    public boolean isConstructorParameterIndicator() {
        return false;
    }

    @Override
    public boolean isMethodParameterIndicator() {
        return false;
    }
}
