package pl.put.poznan.json.tools.controller;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.json.tools.model.JsonComparisonWrapper;
import pl.put.poznan.json.tools.model.ProcessProperties;
import pl.put.poznan.json.tools.service.JsonToolsService;
import pl.put.poznan.json.tools.service.WrongInputException;

import java.util.List;


@RestController
@RequestMapping("/api")
public class JsonToolsController {

    private static final Logger logger = LoggerFactory.getLogger(JsonToolsController.class);
    private final JsonToolsService jsonToolsService;

    public JsonToolsController(JsonToolsService jsonToolsService) {
        this.jsonToolsService = jsonToolsService;
    }

    @PostMapping("/process")
    public String processJson(@RequestBody String json,
                              @RequestParam(value="attributes", defaultValue = "") String[] attributes,
                              @RequestParam(value="attributesMode", defaultValue = "delete") String attributesMode,
                              @RequestParam(value="whiteSpaces", defaultValue = "add") String whiteSpaces,
                              @RequestParam(value="removeNulls", defaultValue = "false") String removeNulls) throws WrongInputException, ParseException {
        ProcessProperties processProperties = new ProcessProperties(json, attributes, attributesMode, whiteSpaces, removeNulls);
        logProcess(processProperties);
        return jsonToolsService.processJson(processProperties);
    }

    @PostMapping("/compare")
    public List<Integer> compareJsons(@RequestBody String jsonComparisonWrapper) throws WrongInputException {
        logCompare(jsonComparisonWrapper);
        return jsonToolsService.compareJsons(jsonComparisonWrapper);
    }
    private void logProcess(ProcessProperties processProperties){
        logger.info("Post request at /api/process");
        logger.debug("JSON: " + processProperties.getJson());
        logger.debug("attributesMode: " + processProperties.getAttributesMode());
        logger.debug("whiteSpaces: " + processProperties.getWhiteSpaces());
        logger.debug("removeNulls: " + processProperties.getRemoveNulls());
    }
    private void logCompare(String jsonComparisonWrapper){
        logger.info("Post request at /api/compare");
        logger.debug("JSONs: " + jsonComparisonWrapper);
    }
}


