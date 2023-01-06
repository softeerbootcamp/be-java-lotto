package kr.codesquad.domain.lotto;

public class WinLotto {

    private final Lotto winLotto;

    private final LottoNumber bonusBall;

    public WinLotto(Lotto winLotto, LottoNumber bonusBall) {
        this.winLotto = winLotto;
        this.bonusBall = bonusBall;
    }

    public Lotto getWinLotto() {
        return winLotto;
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }

}
