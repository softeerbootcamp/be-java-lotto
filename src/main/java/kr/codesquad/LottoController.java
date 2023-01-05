package kr.codesquad;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.Money;
import kr.codesquad.domain.Statistic;

public class LottoController {
    private final LottoGenerator autoLottoGenerator;
    private final LottoGenerator manualLottoGenerator;

    public LottoController() {
        this.autoLottoGenerator = new AutoLottoGenerator();
        this.manualLottoGenerator = new ManualLottoGenerator();
    }

    public Lotto createLotto(Money money) {

        Lotto lotto = new Lotto(money, autoLottoGenerator);
        return lotto;
    }

    public Statistic createStatistics(Lotto lotto) {
        Statistic statistic = new Statistic(lotto.getMoney());
        statistic.calculate(lotto);
        return statistic;
    }
}
