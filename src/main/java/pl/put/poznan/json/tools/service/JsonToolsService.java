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
    private final AttributesService attributesService;
    private final ComparisonService comparisonService;
    private final WhiteSpaceService whiteSpaceService;

    public JsonToolsService(ParametersValidator parametersValidator, AttributesService attributesService, ComparisonService comparisonService, WhiteSpaceService whiteSpaceService) {
        this.parametersValidator = parametersValidator;
        this.attributesService = attributesService;
        this.comparisonService = comparisonService;
        this.whiteSpaceService = whiteSpaceService;
    }

    public String processJson(String json, String[] attributes, String attributesMode, String whiteSpaces) throws WrongJsonException {
        JSONObject jsonObject = parametersValidator.validate(json, attributes, attributesMode, whiteSpaces);
        jsonObject = attributesService.process(jsonObject, attributes, attributesMode);
        jsonObject = whiteSpaceService.process(jsonObject, whiteSpaces);
        return jsonObject.toString();
    }

    public String compareJsons(String[] jsons) {
        //validateJsons();
        //compare();
        return "json";
    }
}
