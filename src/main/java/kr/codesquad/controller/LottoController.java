package kr.codesquad.controller;

import kr.codesquad.domain.Money;
import kr.codesquad.domain.Result;
import kr.codesquad.domain.lotto.*;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class LottoController {

    public void run() {
        OutputView.showRequestTotalPrice();
        Money money = new Money(InputView.inputTotalPrice());
        LottoShop lottoShop = new LottoShop();
        Lottos lottos = purchaseLotto(lottoShop, money);
        WinLotto winLotto = makeWinLotto();
        calculateResult(lottos, winLotto, money);
    }

    private Lottos purchaseLotto(
            LottoShop lottoShop,
            Money money
    ) {
        int totalLottoCount = money.moneyDivide(Lotto.LOTTO_PRICE);
        int manualLottoCount = requestManualLottoCount();
        validateManualLottoCount(totalLottoCount, manualLottoCount);
        OutputView.showRequestManualLottoNumbers(manualLottoCount);
        return printLottos(totalLottoCount, manualLottoCount, lottoShop);
    }

    private int requestManualLottoCount() {
        OutputView.showRequestManualLottoCount();
        return InputView.inputManualLottoCount();
    }

    private void validateManualLottoCount(int totalLottoCount, int manualLottoCount) {
        if (totalLottoCount < manualLottoCount) {
            throw new IllegalArgumentException("로또를 지불하신 금액보다 많이 살 수 없습니다.");
        }
    }

    private Lottos printLottos(
            int totalLottoCount,
            int manualLottoCount,
            LottoShop lottoShop
    ) {
        Lottos lottos = lottoShop.buyLotto(totalLottoCount, manualLottoCount);
        OutputView.showLottoCount(totalLottoCount, manualLottoCount);
        OutputView.showLottoNumbers(lottos);
        return lottos;
    }

    private WinLotto makeWinLotto() {
        OutputView.showRequestWinNumber();
        Lotto winLotto = new Lotto(InputView.inputLotto());

        OutputView.showRequestBonusBall();
        LottoNumber bonusBall = new LottoNumber(InputView.inputBonusBall());
        validateBonusBall(winLotto, bonusBall);

        return new WinLotto(winLotto, bonusBall);
    }

    private void validateBonusBall(Lotto winLotto, LottoNumber bonusBall) {
        if (winLotto.contains(bonusBall)) {
            throw new RuntimeException("당첨 로또 번호안에 보너스 번호가 중복됩니다.");
        }
    }

    private void calculateResult(
            Lottos lottos,
            WinLotto winLotto,
            Money money
    ) {
        OutputView.showResultStatistics();
        Result result = new Result();
        result.addMatchCount(lottos, winLotto);

        OutputView.showLottoListResult(result);
        double sum = result.getProfit();
        printTotalProfit(sum, money);
    }

    private void printTotalProfit(
            double sum,
            Money money
    ) {
        OutputView.showProfitResult(sum, money.getMoney());
    }

}
