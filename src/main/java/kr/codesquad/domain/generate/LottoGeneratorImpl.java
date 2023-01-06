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
        int autoLottoCount = money / LOTTO_PRICE - manualLottoCount;
        if (autoLottoCount < 0)
            throw new IllegalArgumentException("입력한 금액보다 많은 로또를 발급할 수 없습니다.");

        OutputView.guideInputManual();
        List<Lotto> manualLottos = ManualLottoGenerator.generateLottos(manualLottoCount);

        OutputView.printLottoCount(manualLottoCount, autoLottoCount);
        List<Lotto> autoLottos = AutoLottoGenerator.generateLottos(autoLottoCount);

        return Stream.concat(manualLottos.stream(), autoLottos.stream()).collect(Collectors.toList());
    }
}
