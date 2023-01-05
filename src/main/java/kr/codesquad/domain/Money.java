package kr.codesquad.domain;

public class Money {

    public static final int SINGLE_PRICE = 1000; //로또 한 장의 가격은 1000원이다.
    private final int totalMoney;
    private final int manualCnt;

    public Money(int totalMoney, int manualCnt) {
        this.totalMoney = totalMoney;
        this.manualCnt = manualCnt;
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
        if (inputMoney < SINGLE_PRICE) {
            throw new IllegalArgumentException("금액 1000미만임.");
        }
        return inputMoney / SINGLE_PRICE;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

}
