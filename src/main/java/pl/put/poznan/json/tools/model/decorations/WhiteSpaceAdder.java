package pl.put.poznan.json.tools.model.decorations;

import org.json.simple.parser.ParseException;
import pl.put.poznan.json.tools.model.JsonDecorator;
import pl.put.poznan.json.tools.model.JsonObject;
import pl.put.poznan.json.tools.service.ParametersValidator;
import pl.put.poznan.json.tools.service.StringToJsonParser;
import pl.put.poznan.json.tools.service.WrongInputException;


/**
 * This is one of the decoration class, which add white spaces from json and returns file as string
 */
public class WhiteSpaceAdder extends JsonDecorator {

    /**
     * Constructor method
     *
     * @param jsonObject object of interface JsonObject
     */
    public WhiteSpaceAdder(JsonObject jsonObject) {
        super(jsonObject);
    }

    /**
     * This method firstly remove unnecessary white spaces from JSONObject by execute removeWhiteSpaces method
     *  and then add white spaces to JSONObject by executing addWhiteSpaces method
     *
     * @return json file as string without given attributes
     * @throws WrongInputException
     */
    public String getJson() throws WrongInputException {
        String minificatedJson = removeWhiteSpaces(jsonObject.getJson());
        return addWhiteSpaces(minificatedJson);
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

    /**
     * This method add white spaces to JSONObject
     *
     * @param json string which is modified by add white spaces
     * @return JSONObject as string with white spaces
     */
    private String addWhiteSpaces(String json) {
        return json
                .replaceAll("\":", "\": ")
                .replaceAll("\",", "\",\n\t")
                .replaceAll("\\{", "\\{\n\t")
                .replaceAll("\"\\}", "\"\n\\}");
    }

}
