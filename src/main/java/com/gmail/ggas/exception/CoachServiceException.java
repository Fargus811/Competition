package com.gmail.ggas.exception;

public class CoachServiceException extends Exception {
    public CoachServiceException() {

    }

    public CoachServiceException(String message) {
        super(message);
    }

    public CoachServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoachServiceException(Throwable cause) {
        super(cause);
    }

    public CoachServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
