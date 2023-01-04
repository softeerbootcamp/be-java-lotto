package kr.codesquad.model;

import java.util.List;

public class WinningLotto extends Lotto {

    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public Rank compare(Lotto otherLotto) {
        int sameCount = otherLotto.compare(super.numbers);
        boolean isBonus = otherLotto.contains(bonusNumber);

        return Rank.find(sameCount, isBonus);
    }
}
