package pl.put.poznan.json.tools.model.decorations;

import pl.put.poznan.json.tools.model.JsonDecorator;
import pl.put.poznan.json.tools.model.JsonObject;
import pl.put.poznan.json.tools.service.WrongInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NullRemover extends JsonDecorator {

    public NullRemover(JsonObject jsonObject) {
        super(jsonObject);
    }

    public String getJson() throws WrongInputException {
        String jsonString                               = jsonObject.getJson();
        jsonString                                      = jsonString.substring(1, jsonString.length() - 1);
        List<String> jsonAttributes                     = Arrays.asList(jsonString.split("\\s*,\\s*"));
        ArrayList<List<String>> jsonAttributesSplited   = new ArrayList<>();
        ArrayList<String> jsonAttributesRemovedNulls    = new ArrayList<>();

        splitAttributes(jsonAttributes, jsonAttributesSplited);
        removeNulls(jsonAttributesSplited, jsonAttributesRemovedNulls);

        String jsonFinal = "{\n\t" + String.join(",\n\t", jsonAttributesRemovedNulls) + "\n}";

        return jsonFinal;
    }

    private void splitAttributes(List<String> originalList, ArrayList<List<String>> splitedList) {
        originalList.forEach(item -> splitedList.add(Arrays.asList(item.split("\\s*: \\s*"))));

        splitedList.forEach(item -> {
            item.set(0, item.get(0).substring(item.get(0).indexOf("\""), item.get(0).length()));

            if(item.get(1).lastIndexOf("\"") != -1) item.set(1, item.get(1).substring(0, item.get(1).lastIndexOf("\"") + 1));
            else item.set(1, item.get(1).replaceAll("\\s+", ""));
        });
    }

    private void removeNulls(ArrayList<List<String>> originalList, ArrayList<String> removedNullsList) {
        originalList.forEach(item -> {
            if(!item.get(1).matches("\"\\s*\"") && !item.get(1).startsWith("null") && !item.get(1).startsWith("[]") && !item.get(1).startsWith("{}"))
                removedNullsList.add(String.join(": ", item));
        });
    }
}