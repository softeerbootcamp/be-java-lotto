package kr.codesquad.domain.other;

import kr.codesquad.util.LottoUtil;

public class Money {
    public final int money;

    public Money(int money) {
        validateRange(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private void validateRange(int money) {
        if(money < LottoUtil.LOTTO_PRICE)
            throw new IllegalArgumentException("[error] 입력할 수 없는 금액입니다.");
    }
}
