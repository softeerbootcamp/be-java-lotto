package kr.codesquad.exception;

import kr.codesquad.domain.Lotto;

public class CustomValideException{

    public CustomValideException() {

    }

    public static void inputHanLottoCheck(int num) {
        if(num > 6) {
            throw new ArrayIndexOutOfBoundsException("입력 가능 로또 숫자는 6개까지 입니다.");
        }
    }

    public static void numberCheck(String[] split) {
        for (String i : split) {
            String temp = i.trim();
            numberCheckError(temp);
        }
    }

    public static void numberCheckError(String temp) {
        if(Integer.parseInt(temp) < 1|| Integer.parseInt(temp) > 45){
            throw new RuntimeException("1부터 45사이의 숫자를 입력해야합니다");
        }
    }

    public static int buyMoneyCheck(int num1, int num2) {
        if(num1 %  num2 != 0){
            throw new RuntimeException("1000원 단위로 구매가능합니다.");
        }
        return num1 /  num2;
    }

    public static void checkTotalCount(int handLotto, int buyLottoCount) {
        if(handLotto > buyLottoCount){
            throw new RuntimeException("구입 가능한 로또 수를 초과하였습니다");
        }
    }

    public static int duplicateBonnus(Lotto lotto, int num){
        if(lotto.getWinNumber().contains(num)){
            throw new RuntimeException("당첨 숫자 중에 중복되는 수가 있습니다.");
        }
        return num;
    }
}
