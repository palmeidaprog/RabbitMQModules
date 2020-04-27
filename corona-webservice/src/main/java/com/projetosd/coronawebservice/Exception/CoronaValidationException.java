package com.projetosd.coronawebservice.Exception;

public class CoronaValidationException extends Exception {
    public CoronaValidationException(String msg) {
        super(msg);
    }

    public CoronaValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoronaValidationException(Throwable cause) {
        super(cause);
    }

    public CoronaValidationException(String message, Throwable cause,
                                     boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CoronaValidationException() {
    }
}
