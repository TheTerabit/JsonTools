package pl.put.poznan.json.tools.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComparisonService {

    public List<Integer> compare(String s, String s1) {
        s = s.trim();
        s1 = s1.trim();
        if (s.equals(s1))
            return new ArrayList<Integer>();
        else {
            String[] sSplitted = s.split("\\r?\\n");
            String[] s1Splitted = s1.split("\\r?\\n");
            return sSplitted.length > s1Splitted.length ? makeList(sSplitted, s1Splitted) : makeList(s1Splitted, sSplitted);
        }
    }

    private List<Integer> makeList(String[] sSplitted, String[] s1Splitted) {
        ArrayList<Integer> differences = new ArrayList<Integer>();
        for (int i = 0; i < sSplitted.length; i++) {
            if (i < s1Splitted.length) {
                if (!sSplitted[i].equals(s1Splitted[i]))
                    differences.add(i + 1);
            } else
                differences.add(i + 1);
        }
        return differences;
    }
}

