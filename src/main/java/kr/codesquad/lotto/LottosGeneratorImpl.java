package kr.codesquad.lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottosGeneratorImpl implements LottosGenerator {

    @Override
    public List<Lotto> generate(int money) {
        int countOfLotto = countOfLotto(money);

        List<Lotto> manualLottos = manualLottoGenerate(countOfLotto);
        countOfLotto -= manualLottos.size();

        List<Lotto> autoLottos = autoLottoGenerate(countOfLotto);
        return concat(manualLottos, autoLottos);

    }

    private int countOfLotto(int money) {
        int priceOfLotto = 1_000;
        return money / priceOfLotto;
    }

    private List<Lotto> manualLottoGenerate(int countOfLotto) {
        return ManualLottoGenerator.generatorLottos(countOfLotto);
    }

    private List<Lotto> autoLottoGenerate(int countOfLotto) {
        return AutoLottoGenerator.generatorLottos(countOfLotto);
    }

    private List<Lotto> concat(List<Lotto> aLottos, List<Lotto> bLottos) {
        return Stream.concat(aLottos.stream(), bLottos.stream()).collect(Collectors.toList());
    }
}
