package pl.put.poznan.json.tools.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.put.poznan.json.tools.model.ProcessProperties;

/**
 * Parameter Validator class that checks json for correctness of input.
 */
@Service
public class ParametersValidator {

    /**
     * External Logger class to put error message on screen.
     */
    private static final Logger logger = LoggerFactory.getLogger(ParametersValidator.class);

    /**
     * One of a main method that checks json for correctness of input. It used validateAttributtes method,
     * validateWhiteSpaces method, validateRemoveNulls method and validateJson method.
     * If exception occurred, the error log will be put on screen.
     *
     * @param processProperties as ProcessProperties class which contains attributes of json as a String.
     * @throws WrongInputException
     */
    public void validate(ProcessProperties processProperties) throws WrongInputException {
        validateAttributtes(processProperties.getAttributes(), processProperties.getAttributesMode());
        validateWhiteSpaces(processProperties.getWhiteSpaces());
        validateRemoveNulls(processProperties.getRemoveNulls());
        validateJson(processProperties.getJson());
    }

    /**
     * This method checks the json whether contains true or false input to remove null operation.
     * If not, exception occurred.
     *
     * @param removeNulls contains specific part of json as String to compare values.
     * @throws WrongInputException
     */
    private void validateRemoveNulls(String removeNulls) throws WrongInputException {
        if ((!removeNulls.equals("true")) && (!removeNulls.equals("false"))) {
            String errorMessage = "Wrong value of removeNulls parameter";
            logError(errorMessage);
            throw new WrongInputException(errorMessage);
        }
    }

    /**
     * This method compare json mode. If json is not empty and not equals to delete or pick, the exception occurred.
     *
     * @param attributes     array String of attributes specific json.
     * @param attributesMode contains specific part of json as String to compare values.
     * @throws WrongInputException
     */
    private void validateAttributtes(String[] attributes, String attributesMode) throws WrongInputException {
        if ((attributesMode != null) && (!attributesMode.equals("delete")) && (!attributesMode.equals("pick"))) {
            String errorMessage = "Wrong value of attributeMode parameter";
            logError(errorMessage);
            throw new WrongInputException(errorMessage);
        }
    }

    /**
     * This method compare json WhiteSpaces mode. If json is not empty and not equals to delete or add, the exception occurred.
     *
     * @param whiteSpaces contains specific part of json as String to compare values.
     * @throws WrongInputException
     */
    private void validateWhiteSpaces(String whiteSpaces) throws WrongInputException {
        if ((whiteSpaces != null) && (!whiteSpaces.equals("delete")) && (!whiteSpaces.equals("add"))) {
            String errorMessage = "Wrong value of whiteSpace parameter";
            logError(errorMessage);
            throw new WrongInputException(errorMessage);
        }
    }

    /**
     * This method parse json as a String to JSON object.
     *
     * @param json JSON object as String.
     * @throws WrongInputException
     */
    public void validateJson(String json) throws WrongInputException {
        if (!json.equals(" ")) {
            new StringToJsonParser().parse(json);
        }
    }

    /**
     * This method checks correctness of concatenated json input.
     * If array of json String is not correct, an exception occurred.
     *
     * @param json as a String array.
     * @throws WrongInputException
     */
    public void validateSplit(String[] json) throws WrongInputException {
        if (json.length > 2) {
            String errorMessage = "Wrong concatenated input";
            logError(errorMessage);
            throw new WrongInputException(errorMessage);
        }
    }

    /**
     * This method put an error message on a screen.
     *
     * @param message, a message given to display as a logError.
     */
    private void logError(String message) {
        logger.error(message);
    }
}