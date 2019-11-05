package pl.put.poznan.json.tools.model;

import org.json.simple.JSONObject;

import java.util.List;

public class JsonComparisonWrapper {

    private List<String> jsons;

    public JsonComparisonWrapper(List<String> jsons) {
        this.jsons = jsons;
    }

    public List<String> getJsons() {
        return jsons;
    }

    public void setJsons(List<String> jsons) {
        this.jsons = jsons;
    }
}
