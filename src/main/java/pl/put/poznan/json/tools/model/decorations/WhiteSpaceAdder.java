package pl.put.poznan.json.tools.model.decorations;

import pl.put.poznan.json.tools.model.JsonDecorator;
import pl.put.poznan.json.tools.model.JsonObject;
import pl.put.poznan.json.tools.service.WrongInputException;


public class WhiteSpaceAdder extends JsonDecorator {

    public WhiteSpaceAdder(JsonObject jsonObject) {
        super(jsonObject);
    }

    public String getJson() throws WrongInputException {
        return WhiteCharactersAdder();
    }

    private String WhiteCharactersAdder() throws WrongInputException {
        return jsonObject.getJson()
                .replaceAll("\":", "\": ")
                .replaceAll("\",", "\",\n\t")
                .replaceAll("\\{", "\\{\n\t")
                .replaceAll("\"\\}", "\"\n\\}");
    }

}
