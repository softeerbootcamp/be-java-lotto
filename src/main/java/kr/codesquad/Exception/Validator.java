package kr.codesquad.Exception;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Validator {
    public static void isValidMoney(String moneyStr) throws NumberFormatException{
        int money = Integer.parseUnsignedInt(moneyStr);
    }

    public static void isValidLottoNumbers(String[] lottoNumbers) throws IllegalArgumentException, NumberFormatException{
        if (lottoNumbers.length != 6)
            throw new IllegalArgumentException("Lotto should have 6 numbers");
        for (String lottoItr:lottoNumbers){
            Integer.parseInt(lottoItr);
        }
    }


}
