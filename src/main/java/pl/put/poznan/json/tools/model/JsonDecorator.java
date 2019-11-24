package pl.put.poznan.json.tools.model;

import org.json.simple.parser.ParseException;
import pl.put.poznan.json.tools.service.StringToJsonParser;
import pl.put.poznan.json.tools.service.WrongInputException;

abstract public class JsonDecorator implements JsonObject {

    protected JsonObject jsonObject;
    protected StringToJsonParser stringToJsonParser;

    public JsonDecorator(JsonObject jsonObject){
        this.jsonObject = jsonObject;
        this.stringToJsonParser = new StringToJsonParser();
    }

    public String getJson() throws WrongInputException {
        return jsonObject.getJson();
    }

}
