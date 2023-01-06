package kr.codesquad.enums;

public enum ExceptionMessage {
    INVALID_MONEY("구입금액은 1000원 단위이고, 0원 이상 입력가능 합니다."),
    INVALID_LOTTO_NUM_BOUNDARY("로또 번호는 1부터 45까지 입니다."),
    INVALID_NUM("숫자를 입력해주세요."),
    CANNOT_INPUT_NULL("아무것도 입력되지 않았습니다");
    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
