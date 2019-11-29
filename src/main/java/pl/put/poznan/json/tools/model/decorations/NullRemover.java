package pl.put.poznan.json.tools.model.decorations;

import org.json.simple.parser.ParseException;
import pl.put.poznan.json.tools.model.JsonDecorator;
import pl.put.poznan.json.tools.model.JsonObject;
import pl.put.poznan.json.tools.service.WrongInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Decoration class that removes null attributes from given JSON and return it as a String
 */
public class NullRemover extends JsonDecorator {

    /**
     * Constructor method
     * @param jsonObject object of interface JsonObject
     */
    public NullRemover(JsonObject jsonObject) {
        super(jsonObject);
    }

    /**
     * main method of class that removes nulls
     * @return given JSON without null attributes as a String
     * @throws WrongInputException
     */
    public String getJson() throws WrongInputException {
        String jsonString = jsonObject.getJson();
        jsonString = removeBraces(jsonString);
        List<String> jsonAttributes = getAttributes(jsonString);

        ArrayList<List<String>> jsonAttributesSplited = splitAttributes(jsonAttributes);
        ArrayList<String> jsonAttributesRemovedNulls = removeNulls(jsonAttributesSplited);

        String jsonFinal = joinJson(jsonAttributesRemovedNulls);

        return jsonFinal;
    }

    /**
     * method that removes braces at the beginning and the end of JSON String
     * @param json JSON as a String
     * @return String without first and last braces
     */
    private String removeBraces(String json) {
        return json.substring(1, json.length() - 1);
    }

    /**
     * method that splits JSON String to list by ", " to get all attributes separately
     * @param json JSON as a String
     * @return list of attributes from JSON String splited by ", "
     */
    private List<String> getAttributes(String json) {
        return Arrays.asList(json.split("\\s*,\\s*"));
    }

    /**
     * method that splits attributes by ":" to get name and value
     * @param originalList list with attributes from JSON
     * @return list of lists with splited attributes by ":" and removed white spaces in first and last attribute
     */
    private ArrayList<List<String>> splitAttributes(List<String> originalList) {
        ArrayList<List<String>> splitedList = new ArrayList<>();

        originalList.forEach(item -> splitedList.add(Arrays.asList(item.split("\\s*: \\s*"))));

        splitedList.forEach(item -> {
            item.set(0, removeWhiteSpaces(item).get(0));
            item.set(1, removeWhiteSpaces(item).get(1));
        });

        return splitedList;
    }

    /**
     * method that removes white spaces from given list of attributes
     * @param list list of single attribute from JSON with name and value
     * @return list of single attribute without white spaces before first argument and after second argument
     */
    private List<String> removeWhiteSpaces(List<String> list) {
        list.set(0, list.get(0).substring(list.get(0).indexOf("\""), list.get(0).length()));

        if (list.get(1).lastIndexOf("\"") != -1)
            list.set(1, list.get(1).substring(0, list.get(1).lastIndexOf("\"") + 1));
        else
            list.set(1, list.get(1).replaceAll("\\s+", ""));

        return list;
    }

    /**
     * method that removes nulls from list of attributes and merge them with a ": "
     * @param originalList list with attributes that may contain nulls
     * @return list with merged attributes without nulls
     */
    private ArrayList<String> removeNulls(ArrayList<List<String>> originalList) {
        ArrayList<String> removedNullsList = new ArrayList<>();

        originalList.forEach(item -> {
            if (isNull(item))
                removedNullsList.add(String.join(": ", item));
        });

        return removedNullsList;
    }

    /**
     * method that checks if value is a null
     * @param item value of attribute
     * @return false if value is a null, true if not
     */
    private boolean isNull(List<String> item) {
        if (!item.get(1).matches("\"\\s*\"") && !item.get(1).startsWith("null") && !item.get(1).startsWith("[]") && !item.get(1).startsWith("{}"))
            return true;
        else
            return false;
    }

    /**
     * method that join all attributes from given list to String with proper spacing
     * @param jsonList list with JSON attributes without nulls
     * @return JSON list as a string with braces and spacing
     */
    private String joinJson(ArrayList<String> jsonList) {
        return "{\n\t" + String.join(",\n\t", jsonList) + "\n}";
    }
}