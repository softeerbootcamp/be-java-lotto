package kr.codesquad.domain.lotto;

import kr.codesquad.domain.other.Bonus;
import kr.codesquad.domain.winLotto.WinLotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Lotto {

    private List<Integer> numberList;

    public Lotto(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    @Override
    public String toString() {
        return this.numberList.toString();
    }
}
