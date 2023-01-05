package kr.codesquad.domain.lotto.factory;

import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.io.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoManualFactory implements LottoFactory {

    private final Console console = new Console();

    @Override
    public List<Lotto> buyLotto(int amount) {
        if(amount == 0) {
            return new ArrayList<>();
        }
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        return Stream.of(
                        new Lotto(console.inputLottoNum()))
                .collect(Collectors.toList());
    }
}
