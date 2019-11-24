package pl.put.poznan.json.tools.model.decorations;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pl.put.poznan.json.tools.model.JsonDecorator;
import pl.put.poznan.json.tools.model.JsonObject;
import pl.put.poznan.json.tools.service.WrongInputException;

public class AttributesRemover extends JsonDecorator {

    private String[] attributes;

    public AttributesRemover(JsonObject jsonObject, String[] attributes) {
        super(jsonObject);
        this.attributes = attributes;
    }

    public String getJson() throws WrongInputException {
        return removeAtrributes(jsonObject.getJson());
    }

    private String removeAtrributes(String json) throws WrongInputException {
        JSONObject jsonObject = this.stringToJsonParser.parse(json);
        for (int i = 0; i < attributes.length; i++) {
            jsonObject.remove(attributes[i]);
        }
        return jsonObject.toString();
    }

}
