package pl.put.poznan.json.tools.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComparisonService {

    private String[] json1;
    private String[] json2;

    private String trimJson(String json) {
        return json.trim();
    }

    private String[] splitJson(String json) {
        return json.split("\\r?\\n");
    }

    public List<Integer> compare(String json1, String json2) {
        json1 = trimJson(json1);
        json2 = trimJson(json2);
        if (json1.equals(json2))
            return new ArrayList<Integer>();
        else {
            String[] json1Splitted = splitJson(json1);
            String[] json2Splitted = splitJson(json2);
            //String[] sSplitted = json1.split("\\r?\\n");
            //String[] s1Splitted = json2.split("\\r?\\n");
            return json1Splitted.length > json2Splitted.length ? makeList(json1Splitted, json2Splitted) : makeList(json2Splitted, json1Splitted);
        }
    }

    private List<Integer> makeList(String[] json1Splitted, String[] json2Splitted) {
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

