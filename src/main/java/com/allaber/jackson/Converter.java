package com.allaber.jackson;

import com.allaber.models.Location;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Converter {

    private final static String baseFile = "location.json";

    public static String toJSON(Location location) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), location);
        System.out.println("json created!");
        return mapper.writeValueAsString(location);
    }

    public static Location toJavaObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(baseFile), Location.class);
    }

}