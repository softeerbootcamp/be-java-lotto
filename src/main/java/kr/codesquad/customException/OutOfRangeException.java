package kr.codesquad.customException;

public class OutOfRangeException extends InvalidInputException{
    public OutOfRangeException(){}

    public OutOfRangeException(String msg){super(msg);}
}
