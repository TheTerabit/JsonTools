package pl.put.poznan.json.tools.model;

import pl.put.poznan.json.tools.service.WrongInputException;

public interface JsonObject {

    public String getJson() throws WrongInputException;
}
