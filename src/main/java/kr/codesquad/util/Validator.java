package kr.codesquad.util;

import kr.codesquad.enums.ExceptionMessage;
import kr.codesquad.exception.DefaultException;

public class Validator {

    public boolean checkLottoNumBoundary(int num) {
        if (num < 1 || num > 45) {
            throw new DefaultException(ExceptionMessage.INVALID_LOTTO_NUM_BOUNDARY);
        }
        return true;
    }
    public boolean checkTransformabilityToNumber(String input) {
        if (!input.matches("^[0-9]*")) {
            throw new DefaultException(ExceptionMessage.INVALID_NUM);
        }
        return true;
    }
    public boolean checkNotNull(String input) {
        if (input.matches("^$")) {
            throw new DefaultException(ExceptionMessage.CANNOT_INPUT_NULL);
        }
        return true;
    }
}
