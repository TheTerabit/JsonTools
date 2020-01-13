package pl.put.poznan.json.tools.model.decorations;

import org.junit.jupiter.api.Test;
import pl.put.poznan.json.tools.model.RawJson;
import pl.put.poznan.json.tools.service.StringToJsonParser;
import pl.put.poznan.json.tools.service.WrongInputException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

class AttributesPickerTest {

    @Test
    void getAnyAttributesFromJson_ReturnedEmptyJson() throws WrongInputException {
        String json = "{\"name\": \"bartek\",\t\"surname\": \"kowalski\"}";
        String[] attributes = {};
        String expectedJson = "{\n}";

        AttributesPicker attributesPicker = new AttributesPicker(new RawJson(json), attributes);

        assertEquals(attributesPicker.getJson(), expectedJson);
    }

    @Test
    void getAllAttributesFromJson_ReturnedTheSameJson() throws WrongInputException {
        String json = "{\"name\": \"bartek\",\t\"surname\": \"kowalski\"}";
        String[] attributes = {"name", "surname"};
        String expectedJson = "{\n\t\"name\": \"bartek\"\n\t\"surname\": \"kowalski\"\n}";

        AttributesPicker attributesPicker = new AttributesPicker(new RawJson(json), attributes);

        assertEquals(attributesPicker.getJson(), expectedJson);
    }

    @Test
    void getOneAttributeFromJson_ReturnedJsonWithOneAttribute() throws WrongInputException {
        String json = "{\"name\": \"bartek\",\t\"surname\": \"kowalski\"}";
        String[] attributes = {"surname"};
        String expectedJson = "{\n\t\"surname\": \"kowalski\"\n}";

        AttributesPicker attributesPicker = new AttributesPicker(new RawJson(json), attributes);

        assertEquals(attributesPicker.getJson(), expectedJson);
    }

    @Test
    void getTwoAttributesFromJson_ReturnedJsonWithTwoAttributes() throws WrongInputException {
        StringToJsonParser stringToJsonParser = mock(StringToJsonParser.class, RETURNS_DEEP_STUBS);

        String json = "{\"name\": \"bartek\",\t\"surname\": \"kowalski\",\t\"age\": \"21\"}";
        String minificatedJson = "{\"name\":\"bartek\",\"surname\":\"kowalski\",\"age\":\"21\"}";
        String[] attributes = {"surname", "age"};
        String expectedJson = "{\n\t\"surname\": \"kowalski\"\n\t\"age\": \"21\"\n}";

        AttributesPicker attributesPicker = new AttributesPicker(new RawJson(json), attributes);
        when(stringToJsonParser.parse(any(String.class)).toString()).thenReturn(minificatedJson);
        assertEquals(attributesPicker.getJson(), expectedJson);
    }

    @Test
    void getThreeAttributesFromJson_ReturnedJsonWithThreeAttributes() throws WrongInputException {
        StringToJsonParser stringToJsonParser = mock(StringToJsonParser.class, RETURNS_DEEP_STUBS);

        String json = "{\"name\": \"bartek\",\t\"surname\": \"kowalski\",\t\"age\": \"21\",\t\"type\": \"int\"}";
        String minificatedJson = "{\"name\":\"bartek\",\"surname\":\"kowalski\",\"age\":\"21\",\"type\":\"int\"}";
        String[] attributes = {"surname", "age", "name"};
        String expectedJson = "{\n\t\"surname\": \"kowalski\"\n\t\"age\": \"21\"\n\t\"name\": \"bartek\"\n}";

        AttributesPicker attributesPicker = new AttributesPicker(new RawJson(json), attributes);
        when(stringToJsonParser.parse(any(String.class)).toString()).thenReturn(minificatedJson);
        assertEquals(attributesPicker.getJson(), expectedJson);
    }
}