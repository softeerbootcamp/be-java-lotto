package kr.codesquad.domain.generate;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.Money;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGeneratorImpl implements LottoGenerator {
    @Override
    public List<Lotto> generateLottos(Money money) {
        while (true) {
            try {
                int manualLottoCount = InputView.inputManualLottoCount();
                Money change = money.buyManual(manualLottoCount);
                int autoLottoCount = change.getLottoCount();
                return detailGenerate(autoLottoCount, manualLottoCount);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 입력해주세요.");
            }
        }
    }

    public List<Lotto> detailGenerate(int autoLottoCount, int manualLottoCount){
        if (manualLottoCount != 0) {
            OutputView.guideInputManual();
        }
        List<Lotto> manualLottos = ManualLottoGenerator.generateLottos(manualLottoCount);
        OutputView.printLottoCount(manualLottoCount, autoLottoCount);
        List<Lotto> autoLottos = AutoLottoGenerator.generateLottos(autoLottoCount);
        return Stream.concat(manualLottos.stream(), autoLottos.stream()).collect(Collectors.toList());
    }
}
