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

import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.ISOChronology;
import org.jvnet.hk2.annotations.Service;

/**
 *
 * @author Sharmarke Aden (saden1)
 */
@Service
public class JodaTimeController {

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Chronology chronology = ISOChronology.getInstanceUTC();
    private DateTimeZone dateTimeZone = DateTimeZone.UTC;

    public void setChronology(Chronology chronology) {
        lock.writeLock().lock();
        try {
            this.chronology = chronology;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void setDateTimeZone(DateTimeZone dateTimeZone) {
        lock.writeLock().lock();
        try {
            this.dateTimeZone = dateTimeZone;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Chronology getChronology() {
        lock.readLock().lock();
        try {
            return chronology;
        } finally {
            lock.readLock().unlock();
        }
    }

    public DateTimeZone getDateTimeZone() {
        lock.readLock().lock();
        try {
            return dateTimeZone;
        } finally {
            lock.readLock().unlock();
        }
    }

}
