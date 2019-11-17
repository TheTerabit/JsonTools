package pl.put.poznan.json.tools.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComparisonService {

    private String[] json1;
    private String[] json2;

    public List<Integer> compare(String json1, String json2) {
        if (trimJson(json1).equals(trimJson(json2)))
            return new ArrayList<Integer>();
        else {
            String[] json1Splitted = splitJson(trimJson(json1));
            String[] json2Splitted = splitJson(trimJson(json2));
            return json1Splitted.length > json2Splitted.length ? findDifferences(json1Splitted, json2Splitted) : findDifferences(json2Splitted, json1Splitted);
        }
    }

    private String trimJson(String json) {
        return json.trim();
    }

    private String[] splitJson(String json) {
        return json.split("\\r?\\n");
    }

    private List<Integer> findDifferences(String[] json1Splitted, String[] json2Splitted) {
        ArrayList<Integer> differences = new ArrayList<Integer>();
        for (int i = 0; i < json1Splitted.length; i++) {
            if (i < json2Splitted.length) {
                if (!json1Splitted[i].equals(json2Splitted[i]))
                    differences.add(i + 1);
            } else
                differences.add(i + 1);
        }
        return differences;
    }
}

