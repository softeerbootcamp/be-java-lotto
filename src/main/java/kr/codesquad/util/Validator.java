package kr.codesquad.util;

import kr.codesquad.domain.Money;
import kr.codesquad.enums.ExceptionMessage;
import kr.codesquad.exception.DefaultException;

public class Validator {

    public static boolean checkLottoNumBoundary(int num) {
        if (num < 1 || num > 45) {
            throw new DefaultException(ExceptionMessage.INVALID_LOTTO_NUM_BOUNDARY);
        }
        return true;
    }
    public static boolean checkTransformabilityToNumber(String input) {
        if (!input.matches("^[0-9]*")) {
            throw new DefaultException(ExceptionMessage.INVALID_NUM);
        }
        checkNotNull(input);
        return true;
    }
    public static boolean checkNotNull(String input) {
        if (input.matches("^$")) {
            throw new DefaultException(ExceptionMessage.CANNOT_INPUT_NULL);
        }
        return true;
    }
    public static boolean checkLottoNumbers(String[] input) {
        if (input.length < 6) {
            throw new DefaultException(ExceptionMessage.INVALID_LOTTO_NUM_COUNT);
        }
        for (String s : input) {
            checkTransformabilityToNumber(s);
            checkLottoNumBoundary(Integer.parseInt(s));
        }
        return true;
    }
    public static boolean checkMoneyBoundary(String money) {
        checkTransformabilityToNumber(money);
        int intMoney = Integer.parseInt(money);
        if (intMoney % 1000 != 0) {
            throw new DefaultException(ExceptionMessage.INVALID_MONEY_COUNT);
        } else if (intMoney < 1) {
            throw new DefaultException(ExceptionMessage.INVALID_MONEY_BOUNDARY);
        }
        return true;
    }
    public static boolean checkManualLottoCount(String input, Money money) {
        checkTransformabilityToNumber(input);
        int manualLottoCount = Integer.parseInt(input);
        if (money.calculateLottoCount() < manualLottoCount) {
            throw new DefaultException(ExceptionMessage.CANNOT_BUY_OVER_MONEY);
        }
        return true;
    }
}
