package kr.codesquad.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNo;

    public WinningLotto(Lotto lotto, int number) {
        this.bonusNo = LottoNumber.of(number);
        if (lotto.contains(bonusNo)) {
            throw new IllegalArgumentException();
        }
        this.lotto = lotto;
    }

    public Rank match(Lotto userLotto) {
        int matchCount = lotto.match(userLotto);
        boolean matchBonus = userLotto.contains(bonusNo);
        return Rank.valueOf(matchCount, matchBonus);
    }
}
