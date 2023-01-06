package kr.codesquad;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.Row;
import kr.codesquad.domain.Statistic;

public class LottoController {
    private final AutoLottoGenerator autoLottoGenerator;
    private final ManualLottoGenerator manualLottoGenerator;

    public LottoController() {
        this.autoLottoGenerator = new AutoLottoGenerator();
        this.manualLottoGenerator = new ManualLottoGenerator();
    }

    public Statistic createStatistics(Lotto lotto) {
        Statistic statistic = new Statistic(lotto.getMoney());
        statistic.calculate(lotto);
        return statistic;
    }

    public void addManualRowsToLotto(Lotto lotto, int countOfManualRows, String manualRowString) {
        manualLottoGenerator.convertStringToRow(manualRowString);
        lotto.addRowToLotto(countOfManualRows, manualLottoGenerator);
    }

    public void addAutoRowsToLotto(Lotto lotto, int countOfAutoRows) {
        lotto.addRowToLotto(countOfAutoRows, autoLottoGenerator);
    }

    public Row createManualRow(String input) {
        return manualLottoGenerator.convertStringToRow(input);
    }
}
