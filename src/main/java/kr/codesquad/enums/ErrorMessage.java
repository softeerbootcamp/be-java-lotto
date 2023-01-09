package kr.codesquad.enums;

public enum ErrorMessage {
    INVALID_MONEY("invalid money"),
    INVALID_LOTTO_NUMBER("invalid lotto number"),
    CONDITION_GENERATOR_NOT_FOUND("cannot find condition generator");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
