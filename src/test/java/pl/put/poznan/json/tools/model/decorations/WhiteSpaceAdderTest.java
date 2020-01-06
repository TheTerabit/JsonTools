package pl.put.poznan.json.tools.model.decorations;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.put.poznan.json.tools.model.JsonDecorator;
import pl.put.poznan.json.tools.model.JsonObject;
import pl.put.poznan.json.tools.model.RawJson;
import pl.put.poznan.json.tools.service.StringToJsonParser;
import pl.put.poznan.json.tools.service.WrongInputException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class WhiteSpaceAdderTest {

    @Mock
    StringToJsonParser stringToJsonParser = mock(StringToJsonParser.class, RETURNS_DEEP_STUBS);

    @Test
    void GetJson_MinificatedJson_ReturnedJsonWithProperSpacig() throws WrongInputException {

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
}