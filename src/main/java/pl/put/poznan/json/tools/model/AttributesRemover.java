package pl.put.poznan.json.tools.model;

public class AttributesRemover extends JsonDecorator {

    private String[] attributes;

    public AttributesRemover(JsonObject jsonObject, String[] attributes) {
        super(jsonObject);
        this.attributes = attributes;
    }

    public String getJson(){
        //TODO
        //tu zmienic jsonObject.getJson() na taki bez wskazanych atrybutów
        return jsonObject.getJson();
    }

}
