package pl.put.poznan.json.tools.service;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import pl.put.poznan.json.tools.model.*;
import pl.put.poznan.json.tools.model.decorations.*;

import java.util.List;

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

    public String processJson(String json, String[] attributes, String attributesMode, String whiteSpaces, String removeNulls) throws WrongInputException {
        parametersValidator.validate(json, attributes, attributesMode, whiteSpaces, removeNulls);
        JsonObject jsonObject = createJsonObject(json, attributes, attributesMode, whiteSpaces, removeNulls);
        return jsonObject.getJson();
    }

    private JsonObject createJsonObject(String json, String[] attributes, String attributesMode, String whiteSpaces, String removeNulls) {
        JsonObject jsonObject = new RawJson(json);
        if (attributesMode.equals("delete"))
            jsonObject = new AttributesRemover(jsonObject, attributes);
        if (attributesMode.equals("pick"))
            jsonObject = new AttributesPicker(jsonObject, attributes);
        if (removeNulls.equals("true"))
            jsonObject = new NullRemover(jsonObject);
        if (whiteSpaces.equals("delete"))
            jsonObject = new WhiteSpaceRemover(jsonObject);
        if (whiteSpaces.equals("add"))
            jsonObject = new WhiteSpaceAdder(jsonObject);

        return jsonObject;
    }

    public List<Integer> compareJsons(String jsons) throws WrongInputException {
        String[] json = splitJsons(jsons);
        parametersValidator.validateSplit(json);
        parametersValidator.validateJson(json[0]);
        parametersValidator.validateJson(json[1]);
        return comparisonService.compare(json[0], json[1]);
    }

    private String[] splitJsons(String jsons) {
        return jsons.split("###");
    }
}
