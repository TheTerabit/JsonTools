package pl.put.poznan.json.tools.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.put.poznan.json.tools.model.ProcessProperties;

@Service
public class ParametersValidator {

    private static final Logger logger = LoggerFactory.getLogger(ParametersValidator.class);

    public void validate(ProcessProperties processProperties) throws WrongInputException {
        validateAttributtes(processProperties.getAttributes(), processProperties.getAttributesMode());
        validateWhiteSpaces(processProperties.getWhiteSpaces());
        validateRemoveNulls(processProperties.getRemoveNulls());
        validateJson(processProperties.getJson());
    }

    private void validateRemoveNulls(String removeNulls) throws WrongInputException {
        if ((!removeNulls.equals("true")) && (!removeNulls.equals("false"))) {
            String errorMessage = "Wrong value of removeNulls parameter";
            logError(errorMessage);
            throw new WrongInputException(errorMessage);
        }
    }

    private void validateAttributtes(String[] attributes, String attributesMode) throws WrongInputException {
        if ((attributesMode != null) && (!attributesMode.equals("delete")) && (!attributesMode.equals("pick"))){
            String errorMessage = "Wrong value of attributeMode parameter";
            logError(errorMessage);
            throw new WrongInputException(errorMessage);
        }
    }

    private void validateWhiteSpaces(String whiteSpaces) throws WrongInputException {
        if ((whiteSpaces != null) && (!whiteSpaces.equals("delete")) && (!whiteSpaces.equals("add"))){
            String errorMessage = "Wrong value of whiteSpace parameter";
            logError(errorMessage);
            throw new WrongInputException(errorMessage);
        }
    }

    public void validateJson(String json) throws WrongInputException {
        if(!json.equals(" ")) {
            new StringToJsonParser().parse(json);
        }
    }

    public void validateSplit(String[] json) throws WrongInputException {
        if(json.length > 2) {
            String errorMessage = "Wrong concatenated input";
            logError(errorMessage);
            throw new WrongInputException(errorMessage);
        }
    }

    private void logError(String message){
        logger.error(message);
    }
}
