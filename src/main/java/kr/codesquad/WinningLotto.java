package kr.codesquad;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonus;

    public WinningLotto(Lotto lotto, int no) {
        this.bonus = no;
        if (lotto.checkBonus(bonus)) {
            throw new IllegalArgumentException();
        }
        this.lotto = lotto;
    }
    public Rank match(Lotto userLotto) {
        int matchCount = lotto.match(userLotto);
        boolean matchBonus = userLotto.checkBonus(bonus);
        return Rank.valueOf(matchCount, matchBonus);
    }
}
