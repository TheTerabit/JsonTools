package pl.put.poznan.json.tools.model.decorations;

import pl.put.poznan.json.tools.model.JsonDecorator;
import pl.put.poznan.json.tools.model.JsonObject;

public class WhiteSpaceAdder extends JsonDecorator {

    public WhiteSpaceAdder(JsonObject jsonObject) {
        super(jsonObject);
    }

    public String getJson(){
        //TODO
        //tu zmienic jsonObject.getJson() na taki ze spacjami i zreturnowac
        return jsonObject.getJson().toUpperCase();
    }

}