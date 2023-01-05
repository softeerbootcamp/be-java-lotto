package kr.codesquad.lotto;
public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonus;

    public WinningLotto(Lotto lotto, LottoNumber bonus) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException("보너스 번호는 추첨되지 않은 번호만 선택 가능합니다.");
        }
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Rank match(Lotto lotto) {
        int countOfMatch = this.lotto.countOfMatch(lotto);
        boolean matchBonus = this.lotto.contains(bonus);
        return Rank.valueOf(countOfMatch, matchBonus);
    }
}
