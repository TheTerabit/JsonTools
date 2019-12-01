package pl.put.poznan.json.tools.model.decorations;

import org.json.simple.parser.ParseException;
import pl.put.poznan.json.tools.model.JsonDecorator;
import pl.put.poznan.json.tools.model.JsonObject;
import pl.put.poznan.json.tools.service.ParametersValidator;
import pl.put.poznan.json.tools.service.StringToJsonParser;
import pl.put.poznan.json.tools.service.WrongInputException;


/**
 * This is one of the decoration class, which remove white spaces from json and returns file as string
 */
public class WhiteSpaceRemover extends JsonDecorator {

    /**
     * Constructor method
     *
     * @param jsonObject object of interface JsonObject
     */
    public WhiteSpaceRemover(JsonObject jsonObject) {
        super(jsonObject);
    }

    /**
     * This method collect JSONObject as string and remove white spaces
     * by executing removeWhiteSpaces method
     *
     * @return json file as string without white spaces
     * @throws WrongInputException
     */
    public String getJson() throws WrongInputException {
        return removeWhiteSpaces(jsonObject.getJson());
    }

    /**
     * * This method remove all white spaces from JSONObject by external Validator
     *
     * @param json string from which removed white spaces
     * @return string without white spaces
     * @throws WrongInputException
     */
    private String removeWhiteSpaces(String json) throws WrongInputException {
        return this.stringToJsonParser.parse(json).toString();
    }
}
