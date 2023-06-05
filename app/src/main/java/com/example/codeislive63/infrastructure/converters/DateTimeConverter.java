package com.example.codeislive63.infrastructure.converters;

import androidx.room.TypeConverter;

import java.util.Date;

public class DateTimeConverter {
    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long fromDate(Date date) {
        return date == null ? null : date.getTime();
    }
}