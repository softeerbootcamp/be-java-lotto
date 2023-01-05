package kr.codesquad.domain;

import kr.codesquad.exception.ManualLottoCntException;
import kr.codesquad.exception.MoneyNotValidException;

public class Money {

    public static final int SINGLE_PRICE = 1000; //로또 한 장의 가격은 1000원이다.
    private final int totalMoney;
    private final int manualCnt;

    public Money(int totalMoney, int manualCnt) {
        this.totalMoney = totalMoney;
        this.manualCnt = checkManualCntValid(manualCnt);
    }

    public static void checkInputValid(int inputMoney) {
        if (inputMoney < SINGLE_PRICE) {
            throw new MoneyNotValidException();
        }

//        if(inputMoney / SINGLE_PRICE == int);
        //천원 단위로 나누어 떨어져야 함.


    }

    public int checkManualCntValid(int manualCnt) {
        if (manualCnt < 0 || manualCnt > countOfRowICanBuy(totalMoney)) {
            throw new ManualLottoCntException(countOfRowICanBuy(totalMoney));
        }
        return manualCnt;
    }

    public void printStatus() {
        int autoCnt = countOfAutoRows();
        System.out.println("수동으로 " + manualCnt + "장, 자동으로 " + autoCnt + "개를 구매했습니다.");
    }

    public int countOfAutoRows() {
        return countOfRowICanBuy(totalMoney) - manualCnt;
    }
    public int countOfManualRows() {
        return manualCnt;
    }

    public static int countOfRowICanBuy(int inputMoney) {
        checkInputValid(inputMoney);
        return inputMoney / SINGLE_PRICE;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

}
