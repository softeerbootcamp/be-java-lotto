package kr.codesquad.exception;

public class MoneyNotValidException extends LottoException{
    private static final String MESSAGE = "금액은 최소 1000원 이상이어야 하며, 1000원 단위로 입력되어야 합니다.";

    public MoneyNotValidException() {
        super(MESSAGE);
    }
}