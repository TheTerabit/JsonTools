package pl.put.poznan.json.tools.model.decorations;

import org.json.simple.parser.ParseException;
import pl.put.poznan.json.tools.model.JsonDecorator;
import pl.put.poznan.json.tools.model.JsonObject;
import pl.put.poznan.json.tools.service.ParametersValidator;
import pl.put.poznan.json.tools.service.StringToJsonParser;
import pl.put.poznan.json.tools.service.WrongInputException;


public class WhiteSpaceAdder extends JsonDecorator {

    public WhiteSpaceAdder(JsonObject jsonObject) {
        super(jsonObject);
    }

    public String getJson() throws WrongInputException {
        String minificatedJson = removeWhiteSpaces(jsonObject.getJson());
        return addWhiteSpaces(minificatedJson);
    }

    private String removeWhiteSpaces(String json) throws WrongInputException {
        return this.stringToJsonParser.parse(json).toString();
    }

    private String addWhiteSpaces(String json) {
        return json
                .replaceAll("\":", "\": ")
                .replaceAll("\",", "\",\n\t")
                .replaceAll("\\{", "\\{\n\t")
                .replaceAll("\"\\}", "\"\n\\}");
    }

}
