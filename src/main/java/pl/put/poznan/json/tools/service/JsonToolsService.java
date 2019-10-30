package pl.put.poznan.json.tools.service;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */

@Service
public class JsonToolsService {

    private final ParametersValidator parametersValidator;
    private final ComparisonService comparisonService;

    public JsonToolsService(ParametersValidator parametersValidator, ComparisonService comparisonService) {
        this.parametersValidator = parametersValidator;
        this.comparisonService = comparisonService;
    }

    public String processJson(String json, String[] attributes, String attributesMode, String whiteSpaces) throws WrongJsonException {
        parametersValidator.validate(json, attributes, attributesMode, whiteSpaces);
        //TODO
        //sprawdz co, dekoruj i returnuj
        return "json";
    }

    public String compareJsons(String[] jsons) {
        //TODO
        //validateJsons();
        //compare();
        return "json";
    }
}
