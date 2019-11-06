package pl.put.poznan.json.tools.model;

import pl.put.poznan.json.tools.service.WrongInputException;

abstract public class JsonDecorator implements JsonObject {

    protected JsonObject jsonObject;
    public JsonDecorator(JsonObject jsonObject){
        this.jsonObject = jsonObject;
    }

    public String getJson() throws WrongInputException {
        return jsonObject.getJson();
    }

}
