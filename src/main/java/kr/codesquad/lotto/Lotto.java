package kr.codesquad.lotto;

import kr.codesquad.winLotto.WinLotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    public static final int LOTTO_PRICE = 1000;
    private List<Integer> numberList;

    public Lotto(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public int countCorrectNum(WinLotto winLotto) {
        List<Integer> temp = new ArrayList<>(this.numberList);
        temp.retainAll(winLotto.getWinLotto().getNumberList());
        return temp.size();
    }

    public boolean isContainBonusNum(int bonusNum) {
        return this.numberList.contains(bonusNum);
    }


    @Override
    public String toString() {
        return this.numberList.toString();
    }
}
