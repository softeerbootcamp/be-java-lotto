package kr.codesquad.lotto;

import kr.codesquad.io.Console;

import java.util.List;

public class LottoManualFactory implements LottoFactory {

    private final Console console = new Console();

    @Override
    public List<Lotto> buyLotto(int amount) {
        return console.inputManualLottoNum(amount);
    }
}
