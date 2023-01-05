package kr.codesquad.domain.winLotto;

import kr.codesquad.domain.other.Bonus;

import java.util.List;

public class WinLotto {

    private List<Integer> numberList;
    private Bonus bonus;

    public WinLotto(
            List<Integer> numberList,
            Bonus bonus
    ) {
        this.numberList = numberList;
        this.bonus = bonus;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public Bonus getBonus() {
        return bonus;
    }


}
