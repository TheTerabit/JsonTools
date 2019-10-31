package pl.put.poznan.json.tools.model.decorations;

import org.json.simple.JSONObject;
import pl.put.poznan.json.tools.model.JsonDecorator;
import pl.put.poznan.json.tools.model.JsonObject;

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
