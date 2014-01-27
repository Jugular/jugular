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
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.jvnet.hk2.annotations.Service;

/**
 *
 * @author Sharmarke Aden (saden1)
 */
@PerLookup
@Service
public class DateTimeBuilder {

    public NowBuilder now() {
        return new NowBuilder();
    }

    public EpochBuilder epoch(long epoch) {
        return new EpochBuilder(epoch);
    }

    public ChronologyBuilder chronology(Chronology chronology) {
        return new ChronologyBuilder(chronology);
    }

    public TimeZoneBuilder zone(DateTimeZone zone) {
        return new TimeZoneBuilder(zone);
    }

    public static class ChronologyBuilder {

        private final Chronology chronology;

        ChronologyBuilder(Chronology chronology) {
            this.chronology = chronology;
        }

        public DateTime build() {
            return new DateTime(chronology);
        }

    }

    public static class TimeZoneBuilder {

        private final DateTimeZone timeZone;

        TimeZoneBuilder(DateTimeZone timeZone) {
            this.timeZone = timeZone;
        }

        public DateTime build() {
            return new DateTime(timeZone);
        }

    }

    public static class EpochBuilder {

        private final long epoch;

        EpochBuilder(long epoch) {
            this.epoch = epoch;
        }

        public EpochChronologyBuilder chronology(Chronology chronology) {
            return new EpochChronologyBuilder(epoch, chronology);
        }

        public EpochTimeZoneBuilder zone(DateTimeZone zone) {
            return new EpochTimeZoneBuilder(epoch, zone);
        }

        public DateTime build() {
            return new DateTime(epoch);
        }

        public static class EpochChronologyBuilder {

            private final long epoch;
            private final Chronology chronology;

            EpochChronologyBuilder(long epoch, Chronology chronology) {
                this.epoch = epoch;
                this.chronology = chronology;
            }

            public DateTime build() {
                return new DateTime(epoch, chronology);
            }
        }

        public static class EpochTimeZoneBuilder {

            private final long epoch;
            private final DateTimeZone timeZone;

            EpochTimeZoneBuilder(long epoch, DateTimeZone timeZone) {
                this.epoch = epoch;
                this.timeZone = timeZone;
            }

            public DateTime build() {
                return new DateTime(epoch, timeZone);
            }
        }

    }

    public static class NowBuilder {

        NowBuilder() {
        }

        public DateTime build() {
            return new DateTime();
        }

    }

}
