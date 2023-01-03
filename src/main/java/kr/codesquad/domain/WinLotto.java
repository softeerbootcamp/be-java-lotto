package kr.codesquad.domain;

public class WinLotto {

    private final Lotto winLotto;

    public WinLotto(Lotto winLotto) {
        this.winLotto = winLotto;
    }

    public Lotto getWinLotto() {
        return winLotto;
    }

}
