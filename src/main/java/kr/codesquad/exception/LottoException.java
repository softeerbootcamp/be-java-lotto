package kr.codesquad.exception;

public abstract class LottoException extends RuntimeException {

    public LottoException(String message) {
        super(message);
    }
}
