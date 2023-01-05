package kr.codesquad.controller;

import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.domain.lotto.Lottos;
import kr.codesquad.domain.Result;
import kr.codesquad.domain.lotto.WinLotto;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private static final int LOTTO_PRICE = 1_000;

    private static int totalPrice;

    private static int amount;

    public void run() {
        totalPrice = requestMoney();
        amount = totalPrice / LOTTO_PRICE;
        Lottos lottos = purchaseLotto(amount);
        WinLotto winLotto = makeWinLotto();
        calculateResult(lottos, winLotto);
    }

    private int requestMoney() {
        OutputView.showRequestTotalPrice();
        return Integer.parseInt(InputView.inputTotalPrice());
    }

    private Lottos purchaseLotto(int amount) {
        OutputView.showLottoAmount(amount);
        Lottos lottos = new Lottos(amount);

        OutputView.showLottoNumbers(lottos);
        return lottos;
    }

    private WinLotto makeWinLotto() {
        OutputView.showRequestWinNumber();
        Lotto winLotto = getWinLotto();

        OutputView.showRequestBonusball();
        int bonusBall = Integer.parseInt(InputView.inputBonusBall());
        return new WinLotto(winLotto, bonusBall);
    }

    private Lotto getWinLotto() {
        List<Integer> newList = InputView.inputWinLotto()
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(newList);
    }

    private void calculateResult(
            Lottos lottos,
            WinLotto winLotto
    ) {
        OutputView.showResultStatistics();

        Result result = new Result();
        result.addMatchCount(lottos, winLotto);
        OutputView.showLottoListResult(result);

        double sum = result.getProfit();
        printTotalProfit(sum);

    }

    private void printTotalProfit(double sum) {
        OutputView.showProfitResult(sum, totalPrice);
    }

}
