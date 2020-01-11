package exception;

public class SportsmanServiceException extends Exception {
    public SportsmanServiceException() {
    }

    public SportsmanServiceException(String message) {
        super(message);
    }

    public SportsmanServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public SportsmanServiceException(Throwable cause) {
        super(cause);
    }

    public SportsmanServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
