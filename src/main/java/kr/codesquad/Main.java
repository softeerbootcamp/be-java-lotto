package kr.codesquad;

import kr.codesquad.lotto.Lotto;
import kr.codesquad.lottoSystem.LottoChecker;
import kr.codesquad.lottoSystem.LottoMachine;

public class Main {
    public static void main(String[] args) {
        LottoMachine lm = new LottoMachine(1000);
        Lotto lotto = lm.buyLotto();
        lm.printLottoList(lotto.getLottoList());

        LottoChecker lc = new LottoChecker();
        lc.checkLotto(lotto);
    }
}