package kr.codesquad.domain.generate;

import kr.codesquad.domain.Lotto;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGeneratorImpl implements LottoGenerator {
    private static final int LOTTO_PRICE = 1000;
    @Override
    public List<Lotto> generateLottos(int money) {
        int manualLottoCount = InputView.inputManualLottoCount();
        OutputView.guideInputManual();
        List<Lotto> manualLottos = ManualLottoGenerator.generateLottos(manualLottoCount);

        int autoLottoCount = money / LOTTO_PRICE - manualLottoCount;
        OutputView.printLottoCount(manualLottoCount, autoLottoCount);
        List<Lotto> autoLottos = AutoLottoGenerator.generateLottos(autoLottoCount);

        List<Lotto> totalLottos = Stream.concat(manualLottos.stream(), autoLottos.stream()).collect(Collectors.toList());
        return totalLottos;
    }
}
