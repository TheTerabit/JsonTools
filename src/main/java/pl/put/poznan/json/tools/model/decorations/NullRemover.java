package pl.put.poznan.json.tools.model.decorations;

import org.json.simple.parser.ParseException;
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

    public String getJson() throws WrongInputException, ParseException {
        String jsonString = jsonObject.getJson();
        jsonString = removeBraces(jsonString);
        List<String> jsonAttributes = getAttributes(jsonString);

        ArrayList<List<String>> jsonAttributesSplited = splitAttributes(jsonAttributes);
        ArrayList<String> jsonAttributesRemovedNulls = removeNulls(jsonAttributesSplited);

        String jsonFinal = joinJson(jsonAttributesRemovedNulls);

        return jsonFinal;
    }

    private String removeBraces(String json) {
        return json.substring(1, json.length() - 1);
    }

    private List<String> getAttributes(String json) {
        return Arrays.asList(json.split("\\s*,\\s*"));
    }

    private ArrayList<List<String>> splitAttributes(List<String> originalList) {
        ArrayList<List<String>> splitedList = new ArrayList<>();

        originalList.forEach(item -> splitedList.add(Arrays.asList(item.split("\\s*: \\s*"))));

        splitedList.forEach(item -> {
            item.set(0, removeWhiteSpaces(item).get(0));
            item.set(1, removeWhiteSpaces(item).get(1));
        });

        return splitedList;
    }

    private List<String> removeWhiteSpaces(List<String> list) {
        list.set(0, list.get(0).substring(list.get(0).indexOf("\""), list.get(0).length()));

        if(list.get(1).lastIndexOf("\"") != -1)
            list.set(1, list.get(1).substring(0, list.get(1).lastIndexOf("\"") + 1));
        else
            list.set(1, list.get(1).replaceAll("\\s+", ""));

        return list;
    }

    private ArrayList<String> removeNulls(ArrayList<List<String>> originalList) {
        ArrayList<String> removedNullsList = new ArrayList<>();

        originalList.forEach(item -> {
            if(isNull(item))
                removedNullsList.add(String.join(": ", item));
        });

        return removedNullsList;
    }

    private boolean isNull(List<String> item) {
        if(!item.get(1).matches("\"\\s*\"") && !item.get(1).startsWith("null") && !item.get(1).startsWith("[]") && !item.get(1).startsWith("{}"))
            return true;
        else
            return false;
    }

    private String joinJson(ArrayList<String> jsonList) {
        return "{\n\t" + String.join(",\n\t", jsonList) + "\n}";
    }
}