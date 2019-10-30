package pl.put.poznan.json.tools.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
public class ParametersValidator {

    public void validate(String json, String[] attributes, String attributesMode, String whiteSpaces) throws WrongJsonException {
        validateAttributtes(attributes, attributesMode);
        validateWhiteSpaces(whiteSpaces);
        validateJson(json);
    }

    private void validateAttributtes(String[] attributes, String attributesMode) {
        //TODO
    }

    private void validateWhiteSpaces(String whiteSpaces) {
        //TODO
    }

    private void validateJson(String json) throws WrongJsonException {
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(json);
        } catch (ParseException e) {
            throw new WrongJsonException("Wrong JSON input");
        }
    }
}
