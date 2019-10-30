package pl.put.poznan.json.tools.service;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class WhiteSpaceService {
    public JSONObject process(JSONObject jsonObject, String whiteSpaces) {
        return jsonObject;
    }
}
