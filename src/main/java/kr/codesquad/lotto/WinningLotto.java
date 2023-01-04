package kr.codesquad.lotto;

import java.util.List;

public class WinningLotto {

    private final List<LottoNumber> numberList;
    private final LottoNumber bonus;

    public WinningLotto(List<LottoNumber> numberList, LottoNumber bonus) {
        this.numberList = numberList;
        this.bonus = bonus;
    }

    public List<LottoNumber> getNumberList() {
        return numberList;
    }

    public LottoNumber getBonus() {
        return bonus;
    }
}
