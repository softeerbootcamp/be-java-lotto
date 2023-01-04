package kr.codesquad;

public class WinLotto {

    private final Lotto winLotto;
    private final int bonusNum;

    WinLotto(
            Lotto winLotto,
            int bonusNum
    ) {
        this.winLotto = winLotto;
        this.bonusNum = bonusNum;
    }

    public Lotto getWinLotto() {
        return winLotto;
    }

    public int getBonusNum() {
        return bonusNum;
    }


}
