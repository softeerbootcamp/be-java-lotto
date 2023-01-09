package kr.codesquad.customException;

public class AlreadyHasSameNumberException  extends InvalidInputException{
    public AlreadyHasSameNumberException(){}

    public AlreadyHasSameNumberException(String msg){super(msg);}
}
