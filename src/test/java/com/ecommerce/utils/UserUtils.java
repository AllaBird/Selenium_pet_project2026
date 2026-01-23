package com.ecommerce.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class UserUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T readFromJson(String path, Class<T> clazz) {
        try {
            return mapper.readValue(new File(path), clazz);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read json: " + path, e);
        }
    }
}
