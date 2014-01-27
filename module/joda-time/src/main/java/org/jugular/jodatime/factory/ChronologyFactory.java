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
package org.jugular.jodatime.factory;

import javax.inject.Inject;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.CopticChronology;
import org.joda.time.chrono.EthiopicChronology;
import org.joda.time.chrono.GJChronology;
import org.joda.time.chrono.GregorianChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.IslamicChronology;
import org.joda.time.chrono.JulianChronology;
import org.jugular.jodatime.JodaTimeController;
import org.jugular.jodatime.annotation.Joda.Type;
import org.jvnet.hk2.annotations.Service;

/**
 *
 * @author Sharmarke Aden (saden1)
 */
@Service
public class ChronologyFactory {

    private final JodaTimeController controller;

    @Inject
    ChronologyFactory(JodaTimeController controller) {
        this.controller = controller;
    }

    public Chronology create(Type chronologyType, String zoneId) {
        DateTimeZone zone;
        Chronology chronology;

        if (zoneId == null || "".equals(zoneId)) {
            zone = controller.getDateTimeZone();
        } else {
            zone = DateTimeZone.forID(zoneId);
        }

        switch (chronologyType) {
            case BUDDHIST:
                chronology = BuddhistChronology.getInstance(zone);
                break;
            case COPTIC:
                chronology = CopticChronology.getInstance(zone);
                break;
            case ETHIOPIC:
                chronology = EthiopicChronology.getInstance(zone);
                break;
            case GREGORIAN:
                chronology = GregorianChronology.getInstance(zone);
                break;
            case GREGORIAN_JULIAN:
                chronology = GJChronology.getInstance(zone);
                break;
            case ISLAMIC:
                chronology = IslamicChronology.getInstance(zone);
                break;
            case ISO:
                chronology = ISOChronology.getInstance(zone);
                break;
            case JULIAN:
                chronology = JulianChronology.getInstance(zone);
                break;
            default:
                throw new AssertionError("Calender system not supported");
        }

        return chronology;

    }
}
