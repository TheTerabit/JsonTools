package pl.put.poznan.json.tools.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class WrongInputException extends Exception {
    public WrongInputException(String message) {
        super(message);
    }
}
