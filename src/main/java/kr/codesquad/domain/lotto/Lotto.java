package kr.codesquad.domain.lotto;

import kr.codesquad.domain.other.Bonus;
import kr.codesquad.domain.winLotto.WinLotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private List<Integer> numberList;

    public Lotto(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public int countCorrectNum(WinLotto winLotto) {
        List<Integer> temp = new ArrayList<>(this.numberList);
        temp.retainAll(winLotto.getNumberList());
        return temp.size();
    }

    public boolean isContainBonusNum(Bonus bonus) {
        return this.numberList.contains(bonus.getBonusNum());
    }


    @Override
    public String toString() {
        return this.numberList.toString();
    }
}
