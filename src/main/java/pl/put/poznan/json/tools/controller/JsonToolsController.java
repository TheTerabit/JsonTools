package pl.put.poznan.json.tools.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.json.tools.service.JsonToolsService;
import pl.put.poznan.json.tools.service.WrongJsonException;

import java.util.Arrays;


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
                              @RequestParam(value="attributes", defaultValue="") String[] attributes,
                              @RequestParam(value="attributesMode", defaultValue="delete") String attributesMode,
                              @RequestParam(value="whiteSpaces", defaultValue="add") String whiteSpaces) throws WrongJsonException {

        return jsonToolsService.processJson(json, attributes, attributesMode, whiteSpaces);
    }

    @PostMapping("/compare")
    public String compareJsons(@RequestBody String[] jsons){
        return jsonToolsService.compareJsons(jsons);
    }
}
//komentarz
//nie przyjmujcie go


