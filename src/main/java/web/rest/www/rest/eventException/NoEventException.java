package web.rest.www.rest.eventException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoEventException extends Exception {

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public NoEventException(String message) {
        this.message = message;
    }

}
