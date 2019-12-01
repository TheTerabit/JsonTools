package pl.put.poznan.json.tools.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Service class that compares two jsons given as a string and returns the ArrayList
 * with the numbers of lines that are different in given jsons
 */
@Service
public class ComparisonService {

    /**
     * Array of Strings separated by \n or \r
     */
    private String[] json1;
    /**
     * Array of Strings separated by \n or \r
     */
    private String[] json2;

    /**
     * Main method of class that compares two given jsons
     *
     * @param json1 first json file as a string
     * @param json2 second json file as a string
     * @return ArrayList with the numbers of lines that are different in given jsons
     */
    public List<Integer> compare(String json1, String json2) {
        if (checkJsonsEquality(json1, json2))
            return new ArrayList<Integer>();
        else {
            compareAndSetJsons(splitJson(trimJson(json1)), splitJson(trimJson(json2)));
            return findDifferences();
        }
    }

    /**
     * This method removes all white characters from the beginning and the end of the string
     *
     * @param json Json as a string
     * @return string without white characters from the beginning and the end
     */
    private String trimJson(String json) {
        return json.trim();
    }

    /**
     * This method seperates the given string by \n or \s for further analysis
     *
     * @param json Json as a string
     * @return Array of strings separated by \n or \r
     */
    private String[] splitJson(String json) {
        return json.split("\\r?\\n");
    }

    /**
     * This method checks the equality of the given jsons
     *
     * @param json1 first json file as a string
     * @param json2 second json file as a string
     * @return true if trimed jsons are equal or jsons without spaces are equal otherwise returns false
     */
    private boolean checkJsonsEquality(String json1, String json2) {
        if (trimJson(json1).equals(trimJson(json2)) || trimJson(json1).replaceAll("\\s", "").equals(trimJson(json2).replaceAll("\\s", "")))
            return true;
        return false;
    }

    /**
     * This method assings classs attributes to given arguments.
     * The argument, which has length greater than the second becomes the json1 attribute and shorter becomes json2 attribute
     *
     * @param json1Splitted Array of strings separated by \n in first json file
     * @param json2Splitted Array of strings separated by \n in second json file
     */
    private void compareAndSetJsons(String[] json1Splitted, String[] json2Splitted) {
        if (json1Splitted.length > json2Splitted.length) {
            this.json1 = json1Splitted;
            this.json2 = json2Splitted;
        } else {
            this.json1 = json2Splitted;
            this.json2 = json1Splitted;
        }
    }

    /**
     * This method finds the differences between given jsons and return the numbers of lines that are different in given files
     *
     * @return ArrayList with numbers of lines that are different in given jsons
     */
    private List<Integer> findDifferences() {
        ArrayList<Integer> differences = new ArrayList<Integer>();
        for (int i = 0; i < json1.length; i++) {
            if ((checkLinesEquality(i) != null))
                differences.add(checkLinesEquality(i));
        }
        return differences;
    }

    /**
     * This method checks the equality of the given line in both files
     *
     * @param index of the line that is currently being compared
     * @return number of line if the line in given files is different or null if the line is equal in two files
     */
    private Integer checkLinesEquality(int index) {

        if (index < json2.length && !json1[index].equals(json2[index]))
            return index + 1;
        else if (index < json2.length && json1[index].equals(json2[index]))
            return null;
        else
            return index + 1;
    }
}

