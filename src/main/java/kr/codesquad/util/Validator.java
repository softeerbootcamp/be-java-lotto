package kr.codesquad.util;

import kr.codesquad.enums.ExceptionMessage;
import kr.codesquad.exception.DefaultException;

public class Validator {

    public int checkLottoNumBoundary(int num) {
        if (num < 1 || num > 45) {
            throw new DefaultException(ExceptionMessage.INVALID_LOTTO_NUM_BOUNDARY);
        }
        return num;
    }
}
