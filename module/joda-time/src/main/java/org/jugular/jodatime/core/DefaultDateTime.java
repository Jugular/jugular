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
package org.jugular.jodatime.core;

import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.api.PerLookup;
import org.joda.time.DateTime;
import org.jvnet.hk2.annotations.Service;

/**
 *
 * @author Sharmarke Aden (saden1)
 */
@Service
public class DefaultDateTime implements Factory<DateTime> {

    @PerLookup
    @Override
    public DateTime provide() {
        return new DateTime();
    }

    @Override
    public void dispose(DateTime instance) {
        instance = null;
    }

}
