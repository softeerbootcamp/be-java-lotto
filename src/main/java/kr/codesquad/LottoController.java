package kr.codesquad;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.Statistic;

public class LottoController {
    private final AutoLottoGenerator autoLottoGenerator;

    public LottoController() {
        this.autoLottoGenerator = new AutoLottoGenerator();
    }

    public Lotto createLotto(int num) {
        //todo: 랜덤 숫자, 수동 숫자 결정
        Lotto lotto = new Lotto();
        lotto.addRowToLotto(num, autoLottoGenerator);
        return lotto;
    }

    public Statistic createStatistics(Lotto lotto) {
        Statistic statistic = new Statistic(lotto.getInputMoney());
        statistic.calculate(lotto);
        return statistic;
    }
}
