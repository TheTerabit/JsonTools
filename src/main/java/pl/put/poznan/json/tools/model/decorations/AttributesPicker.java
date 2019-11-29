package pl.put.poznan.json.tools.model.decorations;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import pl.put.poznan.json.tools.model.JsonDecorator;
import pl.put.poznan.json.tools.model.JsonObject;
import pl.put.poznan.json.tools.service.WrongInputException;

/**
 * This is one of the decoration class, which picks given attributes from json and returns file as string
 */
public class AttributesPicker extends JsonDecorator {

    /**
     * List of attributes to pick from given json
     */
    private String[] attributes;
    /**
     * String with selected attributes
     */
    private StringBuilder stringBuilder;

    /**
     * Constructor method
     *
     * @param jsonObject object of interface JsonObject
     * @param attributes list of attributes to pick
     */
    public AttributesPicker(JsonObject jsonObject, String[] attributes) {
        super(jsonObject);
        this.attributes = attributes;
    }

    /**
     * @return json file as string with selected attributes
     * @throws WrongInputException
     */
    public String getJson() throws WrongInputException {
        return getJsonWithAttributes(jsonObject.getJson());
    }

    /**
     * This method converts string to JSONObject and selects given attributes from JSONObject
     * by executing pickAttributes method
     *
     * @param json json file as string
     * @return string with selected attributes
     * @throws WrongInputException
     */
    private String getJsonWithAttributes(String json) throws WrongInputException {
        JSONObject jsonObject = this.stringToJsonParser.parse(json);
        return pickAttributes(jsonObject);
    }

    /**
     * This method iterates over the given attributes array and return the string with selected attributes
     *
     * @param json JSONObject from which selected attribute value is passed to concatenateAttributes method
     * @return string with selected attributes
     */
    private String pickAttributes(JSONObject json) {
        stringBuilder = new StringBuilder("{\n\t");
        for (String attribute : attributes) {
            stringBuilder = concatenateAttributes(attribute, json.get(attribute));
        }
        stringBuilder.append("}");
        return stringBuilder.toString().replace("\t}", "}");
    }

    /**
     * This method checks the type of value
     * and concatenates given attribue and value to the rest of string
     *
     * @param attribute        selected attribute to concatenate
     * @param valueOfAttribute selected value of attribute to concatenate
     * @return concatenated string with given attribute and value
     */
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
