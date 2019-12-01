package pl.put.poznan.json.tools.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StringToJsonParser {

    private JSONParser parser = new JSONParser();

    public JSONObject parse(String json) throws WrongInputException {
        JSONObject jsonObject;
        try {
            jsonObject = (JSONObject) parser.parse(json);
        } catch (ParseException e) {
            throw new WrongInputException("Wrong JSON input");
        }
        return jsonObject;
    }
}
