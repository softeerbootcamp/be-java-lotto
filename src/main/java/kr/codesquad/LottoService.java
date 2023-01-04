package kr.codesquad;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.Row;
import kr.codesquad.domain.Statistic;
import kr.codesquad.domain.WinningNumbers;

import java.util.List;

public class LottoService {

    private final LottoGenerator autoLottoGenerator;

    public LottoService() {
        this.autoLottoGenerator = new AutoLottoGenerator();
    }

    public Lotto receiveRandomRows(int inputMoney) {
        List<Row> rows = autoLottoGenerator.generateRows(inputMoney);
        return Lotto.createLotto(rows, inputMoney);
    }

    public Statistic getResult(Lotto lotto) {
        Statistic statistic = new Statistic(lotto.getInputMoney());
        statistic.calculate(lotto.getTotalLotto());
        return statistic;
    }
}
