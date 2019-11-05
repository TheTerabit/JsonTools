package pl.put.poznan.json.tools.model;

abstract public class JsonDecorator implements JsonObject {

    protected JsonObject jsonObject;
    public JsonDecorator(JsonObject jsonObject){
        this.jsonObject = jsonObject;
    }

    public String getJson(){
        return jsonObject.getJson();
    }

}
