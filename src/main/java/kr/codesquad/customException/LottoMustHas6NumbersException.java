package kr.codesquad.customException;

public class LottoMustHas6NumbersException extends InvalidInputException{
    public LottoMustHas6NumbersException(){}

    public LottoMustHas6NumbersException(String msg){super(msg);}
}
