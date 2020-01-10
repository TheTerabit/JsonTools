package pl.put.poznan.json.tools.model.decorations;

import org.junit.jupiter.api.Test;
import pl.put.poznan.json.tools.model.JsonObject;
import pl.put.poznan.json.tools.model.RawJson;
import pl.put.poznan.json.tools.service.WrongInputException;

import static org.junit.Assert.assertEquals;

class NullRemoverTest {

    @Test
    void testGetJsonAll() throws WrongInputException {
        String inputJson =
                "{\n" +
                        "\t\"attr1\": \"val1\",\n" +
                        "\t\"attr2\": null,\n" +
                        "\t\"attr3\": \"null\",\n" +
                        "\t\"attr4\": [],\n" +
                        "\t\"attr5\": \"val2\",\n" +
                        "\t\"attr6\": {},\n" +
                        "\t\"attr7\": \"[]\",\n" +
                        "\t\"attr8\": \"val3\",\n" +
                        "\t\"attr9\": \"\",\n" +
                        "\t\"attr10\": \"val4\"\n" +
                        "}";

        String expectedJson =
                "{\n" +
                        "\t\"attr1\": \"val1\",\n" +
                        "\t\"attr3\": \"null\",\n" +
                        "\t\"attr5\": \"val2\",\n" +
                        "\t\"attr7\": \"[]\",\n" +
                        "\t\"attr8\": \"val3\",\n" +
                        "\t\"attr10\": \"val4\"\n" +
                        "}";

        JsonObject inputJsonObject = new RawJson(inputJson);
        NullRemover nullRemover = new NullRemover(inputJsonObject);
        assertEquals(nullRemover.getJson(), expectedJson);
    }

    @Test
    void testGetJsonNulls() throws WrongInputException {
        String inputJson =
                "{\n" +
                        "\t\"attr1\": \"val1\",\n" +
                        "\t\"attr2\": null,\n" +
                        "\t\"attr3\": \"null\",\n" +
                        "\t\"attr5\": \"val2\",\n" +
                        "\t\"attr8\": \"val3\",\n" +
                        "\t\"attr10\": \"val4\"\n" +
                        "}";

        String expectedJson =
                "{\n" +
                        "\t\"attr1\": \"val1\",\n" +
                        "\t\"attr3\": \"null\",\n" +
                        "\t\"attr5\": \"val2\",\n" +
                        "\t\"attr8\": \"val3\",\n" +
                        "\t\"attr10\": \"val4\"\n" +
                        "}";

        JsonObject inputJsonObject = new RawJson(inputJson);
        NullRemover nullRemover = new NullRemover(inputJsonObject);
        assertEquals(nullRemover.getJson(), expectedJson);
    }

    @Test
    void testGetJsonArrays() throws WrongInputException {
        String inputJson =
                "{\n" +
                        "\t\"attr1\": \"val1\",\n" +
                        "\t\"attr4\": [],\n" +
                        "\t\"attr5\": \"val2\",\n" +
                        "\t\"attr7\": \"[]\",\n" +
                        "\t\"attr8\": \"val3\",\n" +
                        "\t\"attr10\": \"val4\"\n" +
                        "}";

        String expectedJson =
                "{\n" +
                        "\t\"attr1\": \"val1\",\n" +
                        "\t\"attr5\": \"val2\",\n" +
                        "\t\"attr7\": \"[]\",\n" +
                        "\t\"attr8\": \"val3\",\n" +
                        "\t\"attr10\": \"val4\"\n" +
                        "}";

        JsonObject inputJsonObject = new RawJson(inputJson);
        NullRemover nullRemover = new NullRemover(inputJsonObject);
        assertEquals(nullRemover.getJson(), expectedJson);
    }

    @Test
    void testGetJsonObjects() throws WrongInputException {
        String inputJson =
                "{\n" +
                        "\t\"attr1\": \"val1\",\n" +
                        "\t\"attr5\": \"val2\",\n" +
                        "\t\"attr6\": {},\n" +
                        "\t\"attr8\": \"val3\",\n" +
                        "\t\"attr9\": \"{}\",\n" +
                        "\t\"attr10\": \"val4\"\n" +
                        "}";

        String expectedJson =
                "{\n" +
                        "\t\"attr1\": \"val1\",\n" +
                        "\t\"attr5\": \"val2\",\n" +
                        "\t\"attr8\": \"val3\",\n" +
                        "\t\"attr9\": \"{}\",\n" +
                        "\t\"attr10\": \"val4\"\n" +
                        "}";

        JsonObject inputJsonObject = new RawJson(inputJson);
        NullRemover nullRemover = new NullRemover(inputJsonObject);
        assertEquals(nullRemover.getJson(), expectedJson);
    }

    @Test
    void testGetJsonEmptyStrings() throws WrongInputException {
        String inputJson =
                "{\n" +
                        "\t\"attr1\": \"val1\",\n" +
                        "\t\"attr5\": \"val2\",\n" +
                        "\t\"attr8\": \"val3\",\n" +
                        "\t\"attr9\": \"\",\n" +
                        "\t\"attr10\": \"val4\"\n" +
                        "}";

        String expectedJson =
                "{\n" +
                        "\t\"attr1\": \"val1\",\n" +
                        "\t\"attr5\": \"val2\",\n" +
                        "\t\"attr8\": \"val3\",\n" +
                        "\t\"attr10\": \"val4\"\n" +
                        "}";

        JsonObject inputJsonObject = new RawJson(inputJson);
        NullRemover nullRemover = new NullRemover(inputJsonObject);
        assertEquals(nullRemover.getJson(), expectedJson);
    }
}