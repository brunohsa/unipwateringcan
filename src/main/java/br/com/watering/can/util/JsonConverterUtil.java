package br.com.watering.can.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonConverterUtil {

    public static String convertObjectToJson(Class object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String objectJson = mapper.writeValueAsString(object);

        return objectJson;
    }

    public static <T> T convertJsonToObject(String json, Class classe) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Object object = mapper.readValue(json, classe);

        return (T) object;
    }
}
