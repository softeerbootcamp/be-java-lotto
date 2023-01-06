package kr.codesquad.domain.winLotto;

import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.domain.other.Bonus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    public int countCorrectNum(Lotto lotto) {
        List<Integer> temp = new ArrayList<>(this.numberList);
        temp.retainAll(lotto.getNumberList());
        return temp.size();
    }

    public boolean isContainBonusNum(Lotto lotto) {
        return lotto.getNumberList().contains(this.bonus.getBonusNum());
    }

    public Optional<WinCount> findWinningCount(Lotto lotto) {
        return Arrays.stream(WinCount.values())
                .filter(count -> (count.getCount() == countCorrectNum(lotto)))
                .filter(count -> (count.getIsBonus() == isContainBonusNum(lotto)))
                .findFirst();
    }
}
