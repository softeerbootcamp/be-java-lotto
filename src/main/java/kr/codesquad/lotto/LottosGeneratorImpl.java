package kr.codesquad.lotto;

import java.util.List;

public class LottosGeneratorImpl implements LottosGenerator {

    private final int priceOfLotto = 1_000;

    @Override
    public List<Lotto> generator(int money) {
        int countOfLotto = money / priceOfLotto;

        List<Lotto> autoLottos = AutoLottoGenerator.generatorLottos(countOfLotto);
        return autoLottos;
    }
}
