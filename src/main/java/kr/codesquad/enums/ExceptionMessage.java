package kr.codesquad.enums;

public enum ExceptionMessage {
    INVALID_MONEY("구입금액은 1000원 단위이고, 0원 이상 입력가능 합니다.");
    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }
}
