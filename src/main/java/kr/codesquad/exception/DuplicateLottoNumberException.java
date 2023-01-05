package kr.codesquad.exception;

public class DuplicateLottoNumberException extends LottoException{
    private static final String MESSAGE = "한 로또에 중복된 숫자를 입력할 수 없습니다.";

    public DuplicateLottoNumberException() {
        super(MESSAGE);
    }
}


