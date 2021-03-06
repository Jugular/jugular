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
package org.jugular.test.integ.joda.time;

import org.joda.time.Chronology;
import org.jugular.core.api.annotation.Jugular;
import org.jugular.jodatime.annotation.Joda;
import static org.jugular.jodatime.annotation.Joda.Type.GREGORIAN_JULIAN;
import org.jvnet.hk2.annotations.Service;

/**
 *
 * @author Sharmarke Aden (saden1)
 */
@Service
public class ChronologyWithChronologyAndTimeZone {

    private final Chronology constructor;
    @Jugular
    @Joda(chronology = GREGORIAN_JULIAN, zone = "America/Los_Angeles")
    private Chronology field;

    @Jugular
    ChronologyWithChronologyAndTimeZone(
            @Joda(chronology = GREGORIAN_JULIAN, zone = "America/Los_Angeles") Chronology chronology) {
        this.constructor = chronology;
    }

    public Chronology getField() {
        return field;
    }

    public Chronology getConstructor() {
        return constructor;
    }

}
