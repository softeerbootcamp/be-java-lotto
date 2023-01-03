package kr.codesquad.controller;

import kr.codesquad.domain.Lottos;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class LottoController {

    private static final int LOTTO_PRICE = 1_000;

    private static int totalPrice;

    private static int amount;

    public void run() {
        totalPrice = requestMoney();
        amount = totalPrice / LOTTO_PRICE;
        Lottos lottos = purchaseLotto(amount);
    }

    private int requestMoney() {
        OutputView.showRequestTotalPrice();
        return Integer.parseInt(InputView.inputTotalPrice());
    }

    private Lottos purchaseLotto(int amount) {
        Lottos lottos = new Lottos(amount);
        OutputView.showLottoNumbers(lottos);
        return lottos;
    }

}
