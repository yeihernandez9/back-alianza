package api.alianza.exception;

import org.springframework.http.HttpStatus;

public enum Errors implements ErrorResponse {
    ITEM_NOT_FOUND( "NOT_FOUND", HttpStatus.NOT_FOUND , "{info}"),
    ITEM_CONFICT( "NOT_FOUND",HttpStatus.CONFLICT , "{info}");


    String key;
    HttpStatus httpStatus;
    String message;

    Errors(String key, HttpStatus httpStatus, String message) {
        this.message = message;
        this.key = key;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
