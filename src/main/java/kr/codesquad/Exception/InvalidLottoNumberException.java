package kr.codesquad.Exception;

public class InvalidLottoNumberException extends RuntimeException{
    public InvalidLottoNumberException(String message){
        super(message);
    }
}
