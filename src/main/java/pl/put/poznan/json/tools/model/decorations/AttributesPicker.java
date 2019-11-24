package pl.put.poznan.json.tools.model.decorations;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.put.poznan.json.tools.model.JsonDecorator;
import pl.put.poznan.json.tools.model.JsonObject;
import pl.put.poznan.json.tools.service.WrongInputException;

public class AttributesPicker extends JsonDecorator {

    private String[] attributes;
    private StringBuilder stringBuilder;

    public AttributesPicker(JsonObject jsonObject, String[] attributes) {
        super(jsonObject);
        this.attributes = attributes;
    }

    public String getJson() throws WrongInputException {
        return getJsonWithAttributes(jsonObject.getJson());
    }

    private String getJsonWithAttributes(String json) throws WrongInputException {
        JSONObject jsonObject = this.stringToJsonParser.parse(json);
        return pickAttributes(jsonObject);
    }

    private String pickAttributes(JSONObject json) {
        stringBuilder = new StringBuilder("{\n\t");
        for (String attribute : attributes) {
            stringBuilder = concatenateAttributes(attribute, json.get(attribute));
        }
        stringBuilder.append("}");
        return stringBuilder.toString().replace("\t}", "}");
    }

    private StringBuilder concatenateAttributes(String attribute, Object valueOfAttribute) {

        if (valueOfAttribute instanceof Integer || valueOfAttribute instanceof Long || valueOfAttribute instanceof Float || valueOfAttribute instanceof Double || valueOfAttribute instanceof Boolean)
            stringBuilder.append("\"").append(attribute).append("\": ").append(valueOfAttribute).append("\n\t");
        else if (valueOfAttribute instanceof String)
            stringBuilder.append("\"").append(attribute).append("\": ").append("\"").append(valueOfAttribute).append("\"\n\t");
        else if (valueOfAttribute instanceof JSONArray || valueOfAttribute instanceof JSONObject)
            stringBuilder.append("\"").append(attribute).append("\": ").append(valueOfAttribute.toString()).append("\n\t");

        return stringBuilder;
    }
}
