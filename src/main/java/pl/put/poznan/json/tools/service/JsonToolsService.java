package pl.put.poznan.json.tools.service;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
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

    public String processJson(ProcessProperties processProperties) throws WrongInputException, ParseException {
        parametersValidator.validate(processProperties);
        JsonObject jsonObject = createJsonObject(processProperties);
        return jsonObject.getJson();
    }

    private JsonObject createJsonObject(ProcessProperties processProperties) {
        JsonObject jsonObject = new RawJson(processProperties.getJson());
        if (processProperties.getAttributesMode().equals("delete"))
            jsonObject = new AttributesRemover(jsonObject, processProperties.getAttributes());
        if (processProperties.getAttributesMode().equals("pick"))
            jsonObject = new AttributesPicker(jsonObject, processProperties.getAttributes());
        if (processProperties.getRemoveNulls().equals("true"))
            jsonObject = new NullRemover(jsonObject);
        if (processProperties.getWhiteSpaces().equals("delete"))
            jsonObject = new WhiteSpaceRemover(jsonObject);
        if (processProperties.getWhiteSpaces().equals("add"))
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
