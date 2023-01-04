package kr.codesquad.lotto;

public class LottoAutoFactory {

    public final RandomNumFactory randomNumFactory = new RandomNumFactory();

    public Lotto makeLotto() {
        Lotto lotto = new Lotto();
        lotto.getNumberList().addAll(randomNumFactory.makeRandomNum());
        return lotto;
    }
}
