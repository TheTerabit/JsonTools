package pl.put.poznan.json.tools.model.decorations;

import pl.put.poznan.json.tools.model.JsonDecorator;
import pl.put.poznan.json.tools.model.JsonObject;
import pl.put.poznan.json.tools.service.ParametersValidator;
import pl.put.poznan.json.tools.service.WrongInputException;


public class WhiteSpaceRemover extends JsonDecorator {

    public WhiteSpaceRemover(JsonObject jsonObject) {
        super(jsonObject);
    }

    public String getJson() throws WrongInputException{
            return removeWhiteSpaces(jsonObject.getJson());
    }

    private String removeWhiteSpaces(String json) throws WrongInputException
    {
        ParametersValidator parser = new ParametersValidator();
        return parser.validateJson(json).toString();
    }
}
