package pl.put.poznan.json.tools.model.decorations;

import pl.put.poznan.json.tools.model.JsonDecorator;
import pl.put.poznan.json.tools.model.JsonObject;
import pl.put.poznan.json.tools.service.WrongInputException;

public class NullRemover extends JsonDecorator {

    public NullRemover(JsonObject jsonObject) {
        super(jsonObject);
    }

    public String getJson() throws WrongInputException {
        // jsonObject.getJson() zwraca String który musisz przetworzyć odpowiednio i zwrócić
        return jsonObject.getJson();
    }
}
