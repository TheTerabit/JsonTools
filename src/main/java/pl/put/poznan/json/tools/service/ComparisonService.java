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
        else if (trimJson(json1).replaceAll("\\s", "").equals(trimJson(json2).replaceAll("\\s",""))){
            System.out.println(trimJson(json1).replaceAll("\\s", ""));
            System.out.println(trimJson(json2).replaceAll("\\s", ""));
            return new ArrayList<Integer>();
        }
        else {
            String[] json1Splitted = splitJson(trimJson(json1));
            String[] json2Splitted = splitJson(trimJson(json2));
            if(json1Splitted.length > json2Splitted.length) {
                this.json1=json1Splitted;
                this.json2=json2Splitted;
            }
            else {
                this.json1=json2Splitted;
                this.json2=json1Splitted;
            }
            return findDifferences();
        }
    }

    private String trimJson(String json) {
        return json.trim();
    }

    private String[] splitJson(String json) {
        return json.split("\\r?\\n");
    }

    private List<Integer> findDifferences() {
        ArrayList<Integer> differences = new ArrayList<Integer>();
        for (int i = 0; i < json1.length; i++) {
            if (i < json2.length) {
                if (!json1[i].equals(json2[i]))
                    differences.add(i + 1);
            } else
                differences.add(i + 1);
        }
        return differences;
    }
}

