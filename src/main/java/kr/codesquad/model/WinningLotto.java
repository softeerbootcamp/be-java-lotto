package kr.codesquad.model;

public class WinningLotto {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Rank compare(Lotto otherLotto) {
        int sameCount = lotto.compare(otherLotto);
        boolean isBonus = otherLotto.contains(bonusNumber);

        return Rank.FIRST;
    }
}
