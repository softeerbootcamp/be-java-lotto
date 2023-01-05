package kr.codesquad.util.error;

public class CommonErrorMessage {
    public static final String ERROR_TAG = "[ERROR]";
    public static final String RE_ENTER = "다시 입력해주세요";
    public static String includeReEnter(String errorMessage) {
        return errorMessage + RE_ENTER;
    }
}
