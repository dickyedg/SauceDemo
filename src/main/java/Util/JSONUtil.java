package Util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JSONUtil {

    public JsonNode readJSONFromFile(String fileName) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(new File(fileName));

            return jsonNode;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
