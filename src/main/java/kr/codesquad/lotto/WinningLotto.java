package kr.codesquad.lotto;
public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonus;

    public WinningLotto(Lotto lotto, LottoNumber bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Rank match(Lotto lotto) {
        int countOfMatch = this.lotto.countOfMatch(lotto);
        boolean matchBonus = this.lotto.contains(bonus);
        return Rank.valueOf(countOfMatch, matchBonus);
    }
}
