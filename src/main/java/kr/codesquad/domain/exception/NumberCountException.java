package kr.codesquad.domain.exception;

public class NumberCountException extends IllegalArgumentException{
    public static final String NUMBER_COUNT_MESSAGE = "로또에는 서로 다른 6개의 숫자가 필요합니다.";
    public NumberCountException(int count){
        super("서로 다른 " +count + "개의 숫자가 들어왔습니다. " + NUMBER_COUNT_MESSAGE);
    }
}
