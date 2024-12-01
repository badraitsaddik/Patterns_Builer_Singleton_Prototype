package ma.enset;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSerializer<T> {
    public String toJson(T object) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writer().withDefaultPrettyPrinter().writeValueAsString(object);
            return json;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
