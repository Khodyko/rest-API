package web.rest.www.rest.eventException;

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
