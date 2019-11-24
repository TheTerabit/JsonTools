package pl.put.poznan.json.tools.model;

public class ProcessProperties {

    private String json;
    private String[] attributes;
    private String attributesMode;
    private String whiteSpaces;
    private String removeNulls;

    public ProcessProperties(String json, String[] attributes, String attributesMode, String whiteSpaces, String removeNulls) {
        this.json = json;
        this.attributes = attributes;
        this.attributesMode = attributesMode;
        this.whiteSpaces = whiteSpaces;
        this.removeNulls = removeNulls;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String[] getAttributes() {
        return attributes;
    }

    public void setAttributes(String[] attributes) {
        this.attributes = attributes;
    }

    public String getAttributesMode() {
        return attributesMode;
    }

    public void setAttributesMode(String attributesMode) {
        this.attributesMode = attributesMode;
    }

    public String getWhiteSpaces() {
        return whiteSpaces;
    }

    public void setWhiteSpaces(String whiteSpaces) {
        this.whiteSpaces = whiteSpaces;
    }

    public String getRemoveNulls() {
        return removeNulls;
    }

    public void setRemoveNulls(String removeNulls) {
        this.removeNulls = removeNulls;
    }
}

