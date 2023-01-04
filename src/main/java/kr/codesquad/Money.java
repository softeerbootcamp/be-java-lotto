package kr.codesquad;

public class Money {
    /*
     * 주어진 금액 관련 기능을 제공하는 클래스
     */

    final static int TICKET_PRICE = 1000;


    private final int money;
    public final int numOfTickets;

    public Money(int money) {
        this.money = money;
        this.numOfTickets = money / TICKET_PRICE;  // 구매한 로또 수
    }
    double returnRate(long prizeTotal) {
        /*
         * 수익률을 계산하는 메서드
         */

        double priceReturn = (prizeTotal* 100 / (double) this.money);

        if(prizeTotal != 0 && prizeTotal < this.money) {
            priceReturn = 100d - priceReturn;
            priceReturn *= -1;
        }
        return priceReturn;
    }
}
