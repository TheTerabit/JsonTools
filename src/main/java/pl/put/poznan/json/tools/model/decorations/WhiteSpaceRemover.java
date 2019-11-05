package pl.put.poznan.json.tools.model.decorations;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import pl.put.poznan.json.tools.model.JsonDecorator;
import pl.put.poznan.json.tools.model.JsonObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import pl.put.poznan.json.tools.service.ParametersValidator;
import pl.put.poznan.json.tools.service.WrongInputException;

public class WhiteSpaceRemover extends JsonDecorator {

    public WhiteSpaceRemover(JsonObject jsonObject) {
        super(jsonObject);
    }

    public String getJson() {


        JSONParser parser = new JSONParser();
        JSONObject clear_json;
        try {
            clear_json = (JSONObject) parser.parse(jsonObject.getJson());
            return clear_json.toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonObject.getJson();
    }
}
