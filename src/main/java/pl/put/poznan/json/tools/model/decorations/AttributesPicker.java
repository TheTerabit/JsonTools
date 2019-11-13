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

    public AttributesPicker(JsonObject jsonObject, String[] attributes) {
        super(jsonObject);
        this.attributes = attributes;
    }

    public String getJson() throws WrongInputException, ParseException {
        return pickAttributes(jsonObject.getJson());
    }

    private String pickAttributes(String json) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(json);
        return parseAttributes(jsonObject);
    }

    private String parseAttributes(JSONObject json) {
        StringBuilder output = new StringBuilder("{\n\t");
        Object obj;
        for (String attribute : attributes) {
            obj = json.get(attribute);
            if (obj instanceof Integer || obj instanceof Long || obj instanceof Float || obj instanceof Double || obj instanceof Boolean)
                output.append("\"").append(attribute).append("\": ").append(obj).append("\n\t");
            else if (obj instanceof String)
                output.append("\"").append(attribute).append("\": ").append("\"").append(obj).append("\"\n\t");
            else if (obj instanceof JSONArray || obj instanceof JSONObject)
                output.append("\"").append(attribute).append("\": ").append(obj.toString()).append("\n\t");
        }
        output.append("}");
        return output.toString().replace("\t}","}");
    }
}
