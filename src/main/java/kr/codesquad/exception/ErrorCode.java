package kr.codesquad.exception;

public enum ErrorCode {

    MONEY_NOT_ENOUGH("돈이 충분하지 않습니다."),
    ILLEGAL_LOTTO_NUM_COUNT("로또 번호의 수는 6개여야 합니다"),
    ILLEGAL_INPUT_FORMAT("입력 양식을 다시 확인해주세요"),
    NUMBER_ALREADY_EXIST("이미 존재하는 번호입니다"),
    NEGATIVE_NUMBER_ERROR("음수가 아니라 양수로 입력해주세요"),
    OUT_OF_RANGE("숫자는 1 이상 45 이하여야 합니다");
    ILLEGAL_LOTTO_NUM_COUNT("로또 번호의 수는 6개여야 합니다");
    
    private final String message;
    
    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
