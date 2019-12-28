package pl.put.poznan.json.tools.model.decorations;

import org.junit.jupiter.api.Test;
import pl.put.poznan.json.tools.model.RawJson;
import pl.put.poznan.json.tools.service.WrongInputException;

import static org.junit.jupiter.api.Assertions.*;

class WhiteSpaceRemoverTest {

    @Test
    void removeSpacesFromCasualJson() throws WrongInputException {
        String json = "{\n" +
                "\t\"username\": \"maluch126p\",\n" +
                "\t\"password\": \"password1\",\n" +
                "\t\"roomId\": 2,\n" +
                "\t\"topic\": \"Inzynieria Oprogramowania\",\n" +
                "\t\"start\": \"2019-10-22T16:30+02:00\",\n" +
                "\t\"end\": \"2019-10-22T17:30+02:00\"\n" +
                "}";
        String expectedJson = "{\"password\":\"password1\",\"start\":\"2019-10-22T16:30+02:00\",\"topic\":\"Inzynieria Oprogramowania\",\"end\":\"2019-10-22T17:30+02:00\",\"roomId\":2,\"username\":\"maluch126p\"}";

        WhiteSpaceRemover attributesRemover = new WhiteSpaceRemover(new RawJson(json));

        assertEquals(attributesRemover.getJson(), expectedJson);
    }
    @Test
    void removeSpacesFromNotFormatedJson() throws WrongInputException {
        String json = "{\n" +
                "\t\"username\": \"maluch126p\",\n" +

                "\t\"roomId\": 2,\n\n\n\t" + "                  " +
                "\t\"topic\": \"Inzynieria Oprogramowania\",\n" + "       " +
                "\t\"start\": \"2019-10-22T16:30+02:00\",\n\n\t\n" +
                "\t\"end\": \"2019-10-22T17:30+02:00\"\n" + "       \n     \n \t" +
                "}";
        String expectedJson = "{\"start\":\"2019-10-22T16:30+02:00\",\"topic\":\"Inzynieria Oprogramowania\",\"end\":\"2019-10-22T17:30+02:00\",\"roomId\":2,\"username\":\"maluch126p\"}";

        WhiteSpaceRemover attributesRemover = new WhiteSpaceRemover(new RawJson(json));

        assertEquals(attributesRemover.getJson(), expectedJson);
    }
    @Test
    void removeSpacesFromEmptyJson() throws WrongInputException {
        String json = "{" +
                "" +
                "" +
                "}";
        String expectedJson = "{}";

        WhiteSpaceRemover attributesRemover = new WhiteSpaceRemover(new RawJson(json));

        assertEquals(attributesRemover.getJson(), expectedJson);
    }
    @Test
    void removeSpacesFromAdvancedJson() throws WrongInputException {
        String json = "{\n" +
                "  \"firstName\": \"John\",\n" +
                "  \"lastName\": \"Smith\",\n" +
                "  \"isAlive\": true,\n" +
                "  \"age\": 27,\n" +
                "  \"address\": {\n" +
                "    \"streetAddress\": \"21 2nd Street\",\n" +
                "    \"city\": \"New York\",\n" +
                "    \"state\": \"NY\",\n" +
                "    \"postalCode\": \"10021-3100\"\n" +
                "  },\n" +
                "  \"phoneNumbers\": [\n" +
                "    {\n" +
                "      \"type\": \"home\",\n" +
                "      \"number\": \"212 555-1234\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"office\",\n" +
                "      \"number\": \"646 555-4567\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"mobile\",\n" +
                "      \"number\": \"123 456-7890\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"children\": [],\n" +
                "  \"spouse\": null\n" +
                "}";
        String expectedJson = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"isAlive\":true,\"address\":{\"streetAddress\":\"21 2nd Street\",\"city\":\"New York\",\"postalCode\":\"10021-3100\",\"state\":\"NY\"},\"children\":[],\"age\":27,\"phoneNumbers\":[{\"number\":\"212 555-1234\",\"type\":\"home\"},{\"number\":\"646 555-4567\",\"type\":\"office\"},{\"number\":\"123 456-7890\",\"type\":\"mobile\"}],\"spouse\":null}";

        WhiteSpaceRemover attributesRemover = new WhiteSpaceRemover(new RawJson(json));

        assertEquals(attributesRemover.getJson(), expectedJson);
    }

}