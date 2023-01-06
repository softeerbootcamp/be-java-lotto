package kr.codesquad.Exception;

public class Validator {
    public static void isValidMoney(String moneyStr) throws NumberFormatException{
        int money = Integer.parseUnsignedInt(moneyStr);

    }


}
