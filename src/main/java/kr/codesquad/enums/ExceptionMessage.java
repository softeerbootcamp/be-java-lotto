package kr.codesquad.enums;

public enum ExceptionMessage {
    INVALID_MONEY_BOUNDARY("0원 이상 입력가능 합니다."),
    INVALID_MONEY_COUNT("구입금액은 1000원 단위입니다."),
    INVALID_LOTTO_NUM_BOUNDARY("로또 번호는 1부터 45까지 입니다."),
    INVALID_NUM("숫자를 입력해주세요."),
    CANNOT_INPUT_NULL("아무것도 입력되지 않았습니다"),
    INVALID_LOTTO_NUM_COUNT("로또 번호는 6개를 입력하셔야 합니다."),
    CANNOT_BUY_OVER_MONEY("투입하신 금액보다 로또를 더 많이 살 수 없습니다.");
    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
