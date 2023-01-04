package kr.codesquad.domain;

public class WinLotto {

    private final Lotto winLotto;

    private final int bonusBall;

    public WinLotto(Lotto winLotto, int bonusBall) {
        this.winLotto = winLotto;
        this.bonusBall = bonusBall;
    }

    public Lotto getWinLotto() {
        return winLotto;
    }

    public int getBonusBall() {
        return bonusBall;
    }

}
