package com.emre.exception;

import lombok.Getter;

@Getter
public class UserException extends RuntimeException {

    private final ErrorType errorType;

    public UserException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType=errorType;
    }
    //overriredi
    public UserException(ErrorType errorType, String message) {
        super(message);
        this.errorType=errorType;
    }
}
