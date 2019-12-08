package pl.put.poznan.json.tools.service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComparisonServiceTest {

    private final ComparisonService comparisonService = new ComparisonService();

    @Test
    void Compare_TwoFullJsons_ReturnedIntegerList() {
        String json1 = "{\n\tname: \"bartek\",\n\tsurname: \"kowalski\",\n\tage: 21\n}";
        String json2 = "{\n\tname: \"pawel\",\n\tsurname: \"nowak\",\n\tage: 21\n}";
        List<Integer> differences = new ArrayList<>();
        differences.add(2);
        differences.add(3);
        assertEquals(comparisonService.compare(json1, json2), differences);
    }

    @Test
    void Compare_FullJsonAndEmptyJson_ReturnedIntegerListWithAllRowNumbers() {

    }

}
