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
package org.jugular.jodatime.builder;

import org.glassfish.hk2.api.PerLookup;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.IslamicChronology;
import static org.joda.time.chrono.IslamicChronology.LEAP_YEAR_16_BASED;
import org.jvnet.hk2.annotations.Service;

/**
 *
 * @author Sharmarke Aden (saden1)
 */
@PerLookup
@Service
public class ChronologyBuilder {

    public IsoBuilder iso() {
        return new IsoBuilder();
    }

    public IslamicBuilder islamic() {
        return new IslamicBuilder();
    }

    public static class IsoBuilder {

        private DateTimeZone zone;

        IsoBuilder() {
        }

        public IsoBuilder zone(DateTimeZone zone) {
            this.zone = zone;

            return this;
        }

        public Chronology build() {
            return ISOChronology.getInstance(zone);
        }
    }

    public static class IslamicBuilder {

        private DateTimeZone zone;
        private IslamicChronology.LeapYearPatternType type = LEAP_YEAR_16_BASED;

        IslamicBuilder() {
        }

        public IslamicBuilder zone(DateTimeZone zone) {
            this.zone = zone;

            return this;
        }

        public IslamicBuilder type(IslamicChronology.LeapYearPatternType type) {
            this.type = type;

            return this;
        }

        public Chronology build() {
            return IslamicChronology.getInstance(zone, type);
        }
    }

}
