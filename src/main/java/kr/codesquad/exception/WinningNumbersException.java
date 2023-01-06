package kr.codesquad.exception;

public class WinningNumbersException extends LottoException{
    private static final String MESSAGE = "보너스 숫자와 당첨번호는 달라야 합니다.";

    public WinningNumbersException() {
        super(MESSAGE);
    }
}
