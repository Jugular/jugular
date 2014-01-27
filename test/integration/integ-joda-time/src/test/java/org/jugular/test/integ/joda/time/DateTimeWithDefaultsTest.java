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

import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.joda.time.DateTime;
import org.joda.time.chrono.ISOChronology;
import org.jugular.jodatime.JodaTimeController;
import org.jvnet.testing.hk2testng.HK2;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Sharmarke Aden (saden1)
 */
@HK2
public class DateTimeWithDefaultsTest {

    @Inject
    DateTimeWithDefaults service;
    @Inject
    JodaTimeController controller;

    @BeforeMethod
    public void init() {
        assertThat(service).isNotNull();
        assertThat(controller).isNotNull();
    }

    @Test
    public void assertConstructorInjection() {
        DateTime dateTime = service.getConstructor();
        assertThat(dateTime).isNotNull();
        assertThat(dateTime.getZone().getID()).isEqualTo("UTC");
        assertThat(dateTime.getChronology()).isEqualTo(ISOChronology.getInstanceUTC());
    }

    @Test
    public void assertFieldInjection() {
        DateTime dateTime = service.getField();
        assertThat(dateTime).isNotNull();
        assertThat(dateTime.getChronology()).isEqualTo(ISOChronology.getInstanceUTC());
    }

}
