package kr.codesquad.domain;


public class Money {
    private static final int MONEY_PER_LOTTO = 1_000;
    private final int money;
    public Money(int money){
        if (money < 0 || money % MONEY_PER_LOTTO != 0){
            throw new IllegalArgumentException("유효하지 않은 금액입니다. 1000원 단위로 입력해주세요.");
        }
        this.money = money;
    }

    public Money buyManual(int manualLottoCount){
        if (manualLottoCount > getLottoCount())
            throw new IllegalArgumentException("가진 금액보다 더 많은 로또를 구매할 수 없습니다.");
        if (manualLottoCount < 0)
            throw new IllegalArgumentException("음수를 입력할 수 없습니다.");
        return new Money(money - manualLottoCount * MONEY_PER_LOTTO);
    }

    public int getLottoCount(){
        return money / MONEY_PER_LOTTO;
    }

    public int getMoney() {
        return money;
    }
}
