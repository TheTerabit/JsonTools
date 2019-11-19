package pl.put.poznan.json.tools.controller;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.json.tools.model.JsonComparisonWrapper;
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
                              @RequestParam(value="removeNulls", defaultValue = "false") String removeNulls) throws WrongInputException {

        return jsonToolsService.processJson(json, attributes, attributesMode, whiteSpaces, removeNulls);
    }

    @PostMapping("/compare")
    public List<Integer> compareJsons(@RequestBody String jsonComparisonWrapper) throws WrongInputException {
        return jsonToolsService.compareJsons(jsonComparisonWrapper);
    }
}


