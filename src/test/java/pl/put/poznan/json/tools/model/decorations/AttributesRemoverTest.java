package pl.put.poznan.json.tools.model.decorations;

import org.junit.jupiter.api.Test;
import pl.put.poznan.json.tools.model.RawJson;
import pl.put.poznan.json.tools.service.WrongInputException;

import static org.junit.jupiter.api.Assertions.*;

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
}