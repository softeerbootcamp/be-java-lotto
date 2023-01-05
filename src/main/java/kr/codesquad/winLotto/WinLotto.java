package kr.codesquad.winLotto;

import kr.codesquad.lotto.Lotto;

import java.util.List;

public class WinLotto {

    private List<Integer> numberList;
    private int bonusNum;

    public WinLotto(
            List<Integer> numberList,
            int bonusNum
    ) {
        this.numberList = numberList;
        this.bonusNum = bonusNum;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public int getBonusNum() {
        return bonusNum;
    }


}
