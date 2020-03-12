package pl.put.poznan.json.tools.model;

import pl.put.poznan.json.tools.service.StringToJsonParser;
import pl.put.poznan.json.tools.service.WrongInputException;

abstract public class JsonDecorator implements JsonObject {

    protected JsonObject jsonObject;
    protected StringToJsonParser stringToJsonParser;

    public JsonDecorator(JsonObject jsonObject) {
        this.jsonObject = jsonObject;
        this.stringToJsonParser = new StringToJsonParser();
    }

    public String getJson() throws WrongInputException {
        return jsonObject.getJson();
    }

    public void setStringToJsonParser(StringToJsonParser stringToJsonParser) {
        this.stringToJsonParser = stringToJsonParser;
    }

}
