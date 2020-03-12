package pl.put.poznan.json.tools.service;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import pl.put.poznan.json.tools.model.ProcessProperties;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;


class JsonToolsServiceTest {
    ComparisonService comparisonService = mock(ComparisonService.class, RETURNS_DEEP_STUBS);
    ParametersValidator parametersValidator = mock(ParametersValidator.class, RETURNS_DEEP_STUBS);
    JsonToolsService jsonToolsService = new JsonToolsService(parametersValidator, comparisonService);
    String json;

    @Before
    void setUp() {
        json = "{\n" +
                        "\t\"attr1\": \"val1\",\n" +
                        "\t\"attr5\": \"val2\",\n" +
                        "\t\"attr8\": \"val3\",\n" +
                        "\t\"attr10\": \"val4\"\n" +
                "}";
    }

    @Test
    void testProcessJsonInvocationsValidate() throws WrongInputException {
       String[] attributes = {"a1", "a2", "a3"};
       when(comparisonService.compare(any(String.class), any(String.class))).thenReturn(new ArrayList<Integer>());
       jsonToolsService.processJson(new ProcessProperties(json, attributes, "m1", "w1", "r1"));
       verify(parametersValidator).validate(any(ProcessProperties.class));
    }


    @Test
    void testProcessJsonInvocationsValidateReturnValue() throws WrongInputException {
        String[] attributes = {"a1", "a2", "a3"};
        when(comparisonService.compare(any(String.class), any(String.class))).thenReturn(new ArrayList<Integer>());
        assertEquals(jsonToolsService.processJson(new ProcessProperties(json, attributes, "m1", "w1", "r1")), json);
    }


    @Test
    void testCompareJsonsInvocationsValidateSplit() throws Exception {
        when(comparisonService.compare(any(String.class), any(String.class))).thenReturn(new ArrayList<Integer>());
        jsonToolsService.compareJsons(json + "###" + json);
        verify(parametersValidator).validateSplit(any(String[].class));
    }


    @Test
    void testCompareJsonsInvocationsValidateJson() throws Exception {
        when(comparisonService.compare(any(String.class), any(String.class))).thenReturn(new ArrayList<Integer>());
        jsonToolsService.compareJsons(json + "###" + json);
        verify(parametersValidator, times(2)).validateJson(any(String.class));
    }

    @Test
    void testCompareJsonsInvocationsCompare() throws Exception {
        when(comparisonService.compare(any(String.class), any(String.class))).thenReturn(new ArrayList<Integer>());
        jsonToolsService.compareJsons(json + "###" + json);
        verify(comparisonService).compare(any(String.class), any(String.class));
    }


    @Test
    void testCompareJsonsOrder() throws Exception {
         when(comparisonService.compare(any(String.class), any(String.class))).thenReturn(new ArrayList<Integer>());
         jsonToolsService.compareJsons(json + "###" + json);
         InOrder inOrder = inOrder(parametersValidator);
         inOrder.verify(parametersValidator).validateSplit(any(String[].class));
         inOrder.verify(parametersValidator, times(2)).validateJson(any(String.class));
    }

    @Test
    void testCompareJsonsReturnValue() throws Exception {
        ArrayList<Integer> expected = new ArrayList<Integer>();

        when(comparisonService.compare(any(String.class), any(String.class))).thenReturn(new ArrayList<Integer>());
        assertEquals(jsonToolsService.compareJsons(json + "###" + json).size(), expected.size());
    }
}