package kr.codesquad.controller;

import kr.codesquad.domain.Result;
import kr.codesquad.domain.lotto.*;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class LottoController {

    public void run() {
        int money = requestMoney();
        if(money < Lotto.LOTTO_PRICE) {
            throw new RuntimeException("1000원 이상을 지불해 주세요.");
        }
        LottoShop lottoShop = new LottoShop();
        Lottos lottos = purchaseLotto(lottoShop, money);
        WinLotto winLotto = makeWinLotto();
        calculateResult(lottos, winLotto, money);
    }

    private int requestMoney() {
        OutputView.showRequestTotalPrice();
        return Integer.parseInt(InputView.inputTotalPrice());
    }

    private Lottos purchaseLotto(
            LottoShop lottoShop,
            int money
    ) {
        int totalLottoCount = money / Lotto.LOTTO_PRICE;
        OutputView.showRequestManualLottoCount();
        int manualLottoCount = InputView.inputManualLottoCount();
        if(totalLottoCount < manualLottoCount) {
            throw new IllegalArgumentException("로또를 지불하신 금액보다 많이 살 수 없습니다.");
        }
        OutputView.showRequestManualLottoNumbers(manualLottoCount);
        return printLottos(totalLottoCount, manualLottoCount, lottoShop);
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
        if(winLotto.contains(bonusBall)){
            throw new RuntimeException("당첨 로또 번호안에 보너스 번호가 중복됩니다.");
        }
        return new WinLotto(winLotto, bonusBall);
    }

    private void calculateResult(
            Lottos lottos,
            WinLotto winLotto,
            int money
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
            int money
    ) {
        OutputView.showProfitResult(sum, money);
    }

}
