package kr.codesquad.exception;

import kr.codesquad.enums.ExceptionMessage;

public class DefaultException extends RuntimeException{
    public DefaultException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());
    }

    public DefaultException(String message) {
        super(message);
    }
}
