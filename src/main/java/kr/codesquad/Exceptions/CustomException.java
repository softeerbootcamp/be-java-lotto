package kr.codesquad.Exceptions;

public class CustomException extends IllegalArgumentException{
    public CustomException(String message){
        super(message);
        System.out.println("Error : " + message);
    }
}
