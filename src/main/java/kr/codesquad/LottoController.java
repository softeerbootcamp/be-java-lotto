package kr.codesquad;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.Row;
import kr.codesquad.domain.Statistic;
import kr.codesquad.domain.WinningNumbers;

import java.util.List;

public class LottoController {
    private final AutoLottoGenerator autoLottoGenerator;

    public LottoController() {
        this.autoLottoGenerator = new AutoLottoGenerator();
    }

    public Lotto createLotto(int inputMoney) {
        if (inputMoney < Statistic.SINGLE_PRICE) {
            throw new IllegalArgumentException("금액 1000미만임.");
        }
        //todo: 랜덤 숫자, 수동 숫자 결정
        List<Row> rows = autoLottoGenerator.generateRows(inputMoney);
        return Lotto.createLotto(rows, inputMoney);
    }

    public Statistic result(Lotto lotto, WinningNumbers winningNumbers) {
        lotto.compareLotto(winningNumbers);
        return getResult(lotto);
    }

    public Statistic getResult(Lotto lotto) {
        Statistic statistic = new Statistic(lotto.getInputMoney());
        statistic.calculate(lotto.getTotalLotto());
        return statistic;
    }
}
