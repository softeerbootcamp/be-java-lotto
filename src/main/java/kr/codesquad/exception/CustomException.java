package kr.codesquad.exception;

public class CustomException extends RuntimeException {

    //private final String message;

    public CustomException(ErrorCode errorCode){
        //this.errorCode = errorCode;
        //this.message = errorCode.getMessage();
        super(errorCode.getMessage());
    }
}
