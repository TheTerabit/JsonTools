package pl.put.poznan.json.tools.model.decorations;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import pl.put.poznan.json.tools.model.RawJson;
import pl.put.poznan.json.tools.service.StringToJsonParser;
import pl.put.poznan.json.tools.service.WrongInputException;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class WhiteSpaceAdderTest {

    @Test
    void addSpacesToCasualJson() throws WrongInputException {

        StringToJsonParser stringToJsonParser = mock(StringToJsonParser.class, RETURNS_DEEP_STUBS);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("surname","kowalski");
        jsonObject.put("name","bartek");

        String json = "{\"name\": \"bartek\",\t\"surname\": \"kowalski\"}";
        String minificatedJson = "{\"name\":\"bartek\",\"surname\":\"kowalski\"}";
        String expectedJson = "{\n\t\"name\": \"bartek\",\n\t\"surname\": \"kowalski\"\n}";

        WhiteSpaceAdder whiteSpaceAdder = new WhiteSpaceAdder(new RawJson(json));
        whiteSpaceAdder.setStringToJsonParser(stringToJsonParser);

        when(stringToJsonParser.parse(any(String.class)).toString()).thenReturn(minificatedJson);

        assertEquals(whiteSpaceAdder.getJson(),expectedJson);
        verify(stringToJsonParser.parse(json), times(1));
    }


    @Test
    void addSpacesToEmptyJson() throws WrongInputException {

        StringToJsonParser stringToJsonParser = mock(StringToJsonParser.class, RETURNS_DEEP_STUBS);

        JSONObject jsonObject = new JSONObject();

        String json = "{\n}";
        String minificatedJson = "{}";
        String expectedJson = "{\n" +
                "\t\n" +
                "}";

        WhiteSpaceAdder whiteSpaceAdder = new WhiteSpaceAdder(new RawJson(json));
        whiteSpaceAdder.setStringToJsonParser(stringToJsonParser);

        when(stringToJsonParser.parse(any(String.class)).toString()).thenReturn(minificatedJson);

        assertEquals(whiteSpaceAdder.getJson(),expectedJson);
        verify(stringToJsonParser.parse(json), times(1));
    }

    @Test
    void addSpacesToJsonInJson() throws WrongInputException {

        StringToJsonParser stringToJsonParser = mock(StringToJsonParser.class, RETURNS_DEEP_STUBS);

        JSONObject jsonObject = new JSONObject();

        String json = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"isAlive\":true,\"address\":{\"streetAddress\":\"21 2nd Street\",\"city\":\"New York\",\"postalCode\":\"10021-3100\",\"state\":\"NY\"},\"children\":[],\"age\":27,\"phoneNumbers\":[{\"number\":\"212 555-1234\",\"type\":\"home\"},{\"number\":\"646 555-4567\",\"type\":\"office\"},{\"number\":\"123 456-7890\",\"type\":\"mobile\"}],\"spouse\":null}";
        String minificatedJson = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"isAlive\":true,\"address\":{\"streetAddress\":\"21 2nd Street\",\"city\":\"New York\",\"postalCode\":\"10021-3100\",\"state\":\"NY\"},\"children\":[],\"age\":27,\"phoneNumbers\":[{\"number\":\"212 555-1234\",\"type\":\"home\"},{\"number\":\"646 555-4567\",\"type\":\"office\"},{\"number\":\"123 456-7890\",\"type\":\"mobile\"}],\"spouse\":null}";
        String expectedJson = "{\n" +
                "\t\"firstName\": \"John\",\n" +
                "\t\"lastName\": \"Smith\",\n" +
                "\t\"isAlive\": true,\"address\": {\n" +
                "\t\"streetAddress\": \"21 2nd Street\",\n" +
                "\t\"city\": \"New York\",\n" +
                "\t\"postalCode\": \"10021-3100\",\n" +
                "\t\"state\": \"NY\"\n" +
                "\t},\n" +
                "\"children\": [],\"age\": 27,\"phoneNumbers\": [{\n" +
                "\t\"number\": \"212 555-1234\",\n" +
                "\t\"type\": \"home\"\n" +
                "\t},\n" +
                "\n" +
                "\t{\n" +
                "\t\"number\": \"646 555-4567\",\n" +
                "\t\"type\": \"office\"\n" +
                "\t},\n" +
                "\n" +
                "\t{\n" +
                "\t\"number\": \"123 456-7890\",\n" +
                "\t\"type\": \"mobile\"\n" +
                "\t}],\n" +
                "\t\"spouse\": null\n" +
                "}";

        WhiteSpaceAdder whiteSpaceAdder = new WhiteSpaceAdder(new RawJson(json));
        whiteSpaceAdder.setStringToJsonParser(stringToJsonParser);

        when(stringToJsonParser.parse(any(String.class)).toString()).thenReturn(minificatedJson);

        assertEquals(whiteSpaceAdder.getJson(),expectedJson);
        verify(stringToJsonParser.parse(json), times(1));
    }
}