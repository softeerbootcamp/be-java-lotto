package kr.codesquad.domain.lotto.factory;

import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.io.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoManualFactory implements LottoFactory {

    private final Console console = new Console();

    @Override
    public List<Lotto> buyLotto(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        if (amount == 0) {
            return lottos;
        }
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < amount; i++) {
            lottos.add(new Lotto(console.inputLottoNum()));
        }
        return lottos;
    }
}
