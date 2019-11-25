package pl.put.poznan.json.tools.model.decorations;

import org.json.simple.JSONObject;
import pl.put.poznan.json.tools.model.JsonDecorator;
import pl.put.poznan.json.tools.model.JsonObject;
import pl.put.poznan.json.tools.service.WrongInputException;

/**
 * This is one of the decoration class, which removes given attributes from json and returns file as string
 */
public class AttributesRemover extends JsonDecorator {

    /**
     * List of attributes to remove from given json
     */
    private String[] attributes;

    /**
     * Constructor method
     *
     * @param jsonObject object of interface JsonObject
     * @param attributes list of attributes to remove
     */
    public AttributesRemover(JsonObject jsonObject, String[] attributes) {
        super(jsonObject);
        this.attributes = attributes;
    }

    /**
     * @return json file as string without given attributes
     * @throws WrongInputException
     */
    public String getJson() throws WrongInputException {
        return removeAtrributes(jsonObject.getJson());
    }

    /**
     * This method converts string to JSONObject and removes given attributes from JSONObject
     * by executing removeAttributes method
     *
     * @param json json file as string
     * @return json file as string without given attibutes
     * @throws WrongInputException
     */
    private String removeAtrributes(String json) throws WrongInputException {
        JSONObject jsonObject = this.stringToJsonParser.parse(json);
        for (int i = 0; i < attributes.length; i++) {
            jsonObject.remove(attributes[i]);
        }
        return jsonObject.toString();
    }

}
