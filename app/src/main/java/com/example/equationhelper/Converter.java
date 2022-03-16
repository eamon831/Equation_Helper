package com.example.equationhelper;

import androidx.room.TypeConverter;

import com.example.equationhelper.database.User;

import java.util.Arrays;
import java.util.List;

public class Converter {
   /* @TypeConverter
    public User storedStringToLanguages(String value) {
        List<String> langs = Arrays.asList(value.split("\\s*,\\s*"));
        return new User(langs);
    }

    @TypeConverter
    public String languagesToStoredString(User cl) {
        String value = "";

        for (String lang :cl.getCountryLangs())
            value += lang + ",";

        return value;
    }*/
}