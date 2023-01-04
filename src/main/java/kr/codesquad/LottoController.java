package kr.codesquad;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.Statistic;
import kr.codesquad.domain.WinningNumbers;

public class LottoController {
    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public Lotto receiveInput(int inputMoney) {
        if (inputMoney < Statistic.SINGLE_PRICE) {
            throw new IllegalArgumentException("금액 1000미만임.");
        }
        //랜덤 숫자, 수동 숫자 결정
        return lottoService.receiveRandomRows(inputMoney);
    }

    public Statistic result(Lotto lotto, WinningNumbers winningNumbers) {
        lotto.compareLotto(winningNumbers);
        return lottoService.getResult(lotto);
    }
}
