package pl.put.poznan.json.tools.model.decorations;

import org.json.simple.JSONObject;
import pl.put.poznan.json.tools.model.JsonDecorator;
import pl.put.poznan.json.tools.model.JsonObject;
import pl.put.poznan.json.tools.service.ParametersValidator;
import pl.put.poznan.json.tools.service.WrongInputException;


public class WhiteSpaceRemover extends JsonDecorator {

    public WhiteSpaceRemover(JsonObject jsonObject) {
        super(jsonObject);
    }

    public String getJson() throws WrongInputException{
            return WhiteCharactersRemover();
    }

    private String WhiteCharactersRemover() throws WrongInputException
    {
        ParametersValidator parser = new ParametersValidator();
        JSONObject clear_json;
        clear_json = parser.validateJson(jsonObject.getJson());
        return clear_json.toString();
    }
}
