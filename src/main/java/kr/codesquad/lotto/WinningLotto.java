package kr.codesquad.lotto;

import java.util.List;

public class WinningLotto {

    private final List<Integer> numberList;
    private final int bonus;

    public WinningLotto(List<Integer> numberList, int bonus) {
        this.numberList = numberList;
        this.bonus = bonus;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public int getBonus() {
        return bonus;
    }
}
