package pl.put.poznan.json.tools.model;

public class RawJson implements JsonObject {

    private String json;

    public RawJson(String json) {
        this.json = json;
    }

    @Override
    public String getJson() {
        return json;
    }
}
