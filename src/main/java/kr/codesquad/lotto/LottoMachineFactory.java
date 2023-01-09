package kr.codesquad.lotto;

import kr.codesquad.lotto.io.LottoIOManagerImpl;

public final class LottoMachineFactory {

    public static LottoMachine createLottoMachine() {
        return new LottoMachine(new LottosGeneratorImpl(), new LottoIOManagerImpl());
    }
}
