package pl.put.poznan.json.tools.model;

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
