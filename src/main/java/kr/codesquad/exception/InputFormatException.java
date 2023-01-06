package kr.codesquad.exception;

public class InputFormatException extends RuntimeException{

    public InputFormatException(){

    }
    public InputFormatException(String message){
        super(message);
    }

}
