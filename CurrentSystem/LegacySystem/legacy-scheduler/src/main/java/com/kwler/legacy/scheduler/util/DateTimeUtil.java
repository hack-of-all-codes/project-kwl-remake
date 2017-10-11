package com.kwler.legacy.scheduler.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DateTimeUtil {

    public static Long toMs(LocalDateTime localDateTime) {
        return localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
    }
}
