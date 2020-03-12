package pl.put.poznan.json.tools.model.decorations;

import org.junit.jupiter.api.Test;
import pl.put.poznan.json.tools.model.RawJson;
import pl.put.poznan.json.tools.service.StringToJsonParser;
import pl.put.poznan.json.tools.service.WrongInputException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

class AttributesRemoverTest {

    @Test
    void removeZeroAttributesFromJson_ReturnedOriginalJson() throws WrongInputException {
        String json = "{\"name\": \"bartek\",\t\"surname\": \"kowalski\"}";
        String[] attributes = {};
        String expectedJson = "{\"surname\":\"kowalski\",\"name\":\"bartek\"}";

        AttributesRemover attributesRemover = new AttributesRemover(new RawJson(json), attributes);

        assertEquals(attributesRemover.getJson(), expectedJson);
    }

    @Test
    void removeAllAttributesFromJson_ReturnedEmptyJson() throws WrongInputException {
        String json = "{\"name\": \"bartek\",\t\"surname\": \"kowalski\"}";
        String[] attributes = {"name", "surname"};
        String expectedJson = "{}";

        AttributesRemover attributesRemover = new AttributesRemover(new RawJson(json), attributes);

        assertEquals(attributesRemover.getJson(), expectedJson);
    }

    @Test
    void removeOneAttributeFromJson_ReturnedJsonWithoutOneAttribute() throws WrongInputException {
        String json = "{\"name\": \"bartek\",\t\"surname\": \"kowalski\"}";
        String[] attributes = {"name"};
        String expectedJson = "{\"surname\":\"kowalski\"}";

        AttributesRemover attributesRemover = new AttributesRemover(new RawJson(json), attributes);

        assertEquals(attributesRemover.getJson(), expectedJson);
    }

    @Test
    void removeTwoAttributesFromJson_ReturnedJsonWithoutTwoAttributes() throws WrongInputException {
        StringToJsonParser stringToJsonParser = mock(StringToJsonParser.class, RETURNS_DEEP_STUBS);

        String json = "{\"name\": \"bartek\",\t\"surname\": \"kowalski\",\t\"age\": \"21\"}";
        String minificatedJson = "{\"name\":\"bartek\",\"surname\":\"kowalski\",\"age\":\"21\"}";
        String[] attributes = {"surname", "age"};
        String expectedJson = "{\"name\":\"bartek\"}";

        AttributesRemover attributesRemover = new AttributesRemover(new RawJson(json), attributes);
        when(stringToJsonParser.parse(any(String.class)).toString()).thenReturn(minificatedJson);
        assertEquals(attributesRemover.getJson(), expectedJson);
    }

    @Test
    void removeThreeAttributesFromJson_ReturnedJsonWithoutThreeAttributes() throws WrongInputException {
        StringToJsonParser stringToJsonParser = mock(StringToJsonParser.class, RETURNS_DEEP_STUBS);

        String json = "{\"name\": \"bartek\",\t\"surname\": \"kowalski\",\t\"age\": \"21\",\t\"type\": \"int\"}";
        String minificatedJson = "{\"name\":\"bartek\",\"surname\":\"kowalski\",\"age\":\"21\",\"type\":\"int\"}";
        String[] attributes = {"surname", "age", "name"};
        String expectedJson = "{\"type\":\"int\"}";

        AttributesRemover attributesRemover = new AttributesRemover(new RawJson(json), attributes);
        when(stringToJsonParser.parse(any(String.class)).toString()).thenReturn(minificatedJson);
        assertEquals(attributesRemover.getJson(), expectedJson);
    }
}