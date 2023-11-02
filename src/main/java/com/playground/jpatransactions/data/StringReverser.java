package com.playground.jpatransactions.data;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class StringReverser implements AttributeConverter<String, String> {
    @Override
    public String convertToDatabaseColumn(String attribute) {
        return reverse(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return reverse(dbData);
    }

    private String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
