package kr.codesquad.exception;

public class InputCountException extends RuntimeException{

    public InputCountException(){

    }
    public InputCountException(String message){
        super(message);
    }
}
