package pl.put.poznan.json.tools.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ComparisonService {

    private String[] json1;
    private String[] json2;

    public List<Integer> compare(String json1, String json2) {
        if (trimJson(json1).equals(trimJson(json2)) || trimJson(json1).replaceAll("\\s", "").equals(trimJson(json2).replaceAll("\\s","")))
            return new ArrayList<Integer>();
        else {
            compareJsons(splitJson(trimJson(json1)), splitJson(trimJson(json2)));
            return findDifferences();
        }
    }

    private String trimJson(String json) {
        return json.trim();
    }

    private String[] splitJson(String json) {
        return json.split("\\r?\\n");
    }

    private void compareJsons(String[] json1Splitted, String[] json2Splitted) {
        if(json1Splitted.length > json2Splitted.length) {
            this.json1=json1Splitted;
            this.json2=json2Splitted;
        }
        else {
            this.json1=json2Splitted;
            this.json2=json1Splitted;
        }
    }

    private List<Integer> findDifferences() {
        ArrayList<Integer> differences = new ArrayList<Integer>();
        for (int i = 0; i < json1.length; i++) {
            if((addDifferencesToList(i) != null))
                differences.add(addDifferencesToList(i));
        }
        return differences;
    }

    private Integer addDifferencesToList(int index) {
        if (index < json2.length) {
            if (!json1[index].equals(json2[index]))
                return index+1;
        } else
            return index+1;
        return null;
    }
}

