package kr.codesquad.lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottosGeneratorImpl implements LottosGenerator {

    @Override
    public List<Lotto> generator(int money) {
        int priceOfLotto = 1_000;
        int countOfLotto = money / priceOfLotto;
        List<Lotto> manualLottos = ManualLottoGenerator.generatorLottos(countOfLotto);
        countOfLotto -= manualLottos.size();

        List<Lotto> autoLottos = AutoLottoGenerator.generatorLottos(countOfLotto);

        return Stream.concat(
                manualLottos.stream(), autoLottos.stream())
                .collect(Collectors.toList());
    }
}
