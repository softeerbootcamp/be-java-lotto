package kr.codesquad.exception;

public class NumberNotValidException extends LottoException{
    private static final String MESSAGE = "숫자는 1이상 45 이하로 선택해야 합니다.";

    public NumberNotValidException() {
        super(MESSAGE);
    }
}
