package kr.codesquad.customException;

public class InvalidInputException extends NumberFormatException{

    public InvalidInputException(){}

    public InvalidInputException(String msg)
    {
        super(msg);
    }
}
