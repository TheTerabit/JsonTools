package pl.put.poznan.json.tools.model.decorations;

import pl.put.poznan.json.tools.model.JsonDecorator;
import pl.put.poznan.json.tools.model.JsonObject;

public class AttributesPicker extends JsonDecorator {

    private String[] attributes;

    public AttributesPicker(JsonObject jsonObject, String[] attributes) {
        super(jsonObject);
        this.attributes = attributes;
    }

    public String getJson(){
        //TODO
        //tu zmienic jsonObject.getJson() na taki tylko z wybranymi atrybutami
        return jsonObject.getJson();
    }

}
