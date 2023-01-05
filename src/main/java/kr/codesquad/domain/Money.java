package kr.codesquad.domain;

public class Money {

    public static final int SINGLE_PRICE = 1000; //로또 한 장의 가격은 1000원이다.
    public static int getRowCountICanBuy(int inputMoney) {
        if (inputMoney < SINGLE_PRICE) {
            throw new IllegalArgumentException("금액 1000미만임.");
        }
        return inputMoney / SINGLE_PRICE;
    }
}
