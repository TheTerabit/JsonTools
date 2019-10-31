package pl.put.poznan.json.tools.model.decorations;

import pl.put.poznan.json.tools.model.JsonDecorator;
import pl.put.poznan.json.tools.model.JsonObject;

public class AttributesRemover extends JsonDecorator {

    private String[] attributes;

    public AttributesRemover(JsonObject jsonObject, String[] attributes) {
        super(jsonObject);
        this.attributes = attributes;
    }

    public String getJson(){
        //TODO
        //tu zmienic jsonObject.getJson() na taki bez wskazanych atrybutów
        return jsonObject.getJson() + "\n\n" + jsonObject.getJson();
    }

}
