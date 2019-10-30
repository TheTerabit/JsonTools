package pl.put.poznan.json.tools.service;

import org.springframework.stereotype.Service;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */

@Service
public class JsonToolsService {

    public JsonToolsService() {
    }

    public String processJson(String json, String[] attributes, String attributesMode, String whiteSpaces) {
        validateParameters();
        processAttributes();
        processWhiteSpaces();
        return "json";
    }

    public String compareJsons(String[] jsons) {
        validateJsons();
        compare();
        return "json";
    }
}
