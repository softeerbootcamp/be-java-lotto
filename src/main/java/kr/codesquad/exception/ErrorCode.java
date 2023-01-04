package kr.codesquad.exception;

public enum ErrorCode {

    MONEY_NOT_ENOUGH("돈이 충분하지 않습니다.");
    private final String message;
    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
