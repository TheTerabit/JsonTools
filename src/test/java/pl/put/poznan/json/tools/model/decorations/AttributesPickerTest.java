package pl.put.poznan.json.tools.model.decorations;

import org.junit.jupiter.api.Test;
import pl.put.poznan.json.tools.model.RawJson;
import pl.put.poznan.json.tools.service.WrongInputException;

import static org.junit.jupiter.api.Assertions.*;

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

}