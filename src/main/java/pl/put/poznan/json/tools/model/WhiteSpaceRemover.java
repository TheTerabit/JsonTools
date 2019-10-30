package pl.put.poznan.json.tools.model;

import org.json.simple.JSONObject;

public class WhiteSpaceRemover extends JsonDecorator {

    public WhiteSpaceRemover(JsonObject jsonObject) {
        super(jsonObject);
    }

    public String getJson(){
        //TODO
        //tu zmienic jsonObject.getJson() na taki bez spacji i zreturnowac
        return jsonObject.getJson();
    }
}
