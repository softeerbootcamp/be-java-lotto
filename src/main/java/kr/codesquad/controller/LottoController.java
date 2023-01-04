package kr.codesquad.controller;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.Lottos;
import kr.codesquad.domain.WinLotto;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private static final int LOTTO_PRICE = 1_000;

    private static int totalPrice;

    private static int amount;

    private static int[] sameCnt = new int[7];

    public void run() {
        totalPrice = requestMoney();
        amount = totalPrice / LOTTO_PRICE;
        Lottos lottos = purchaseLotto(amount);
        int bonusBall = getBonusBall();
        WinLotto winLotto  = makeWinLotto();
        findSameNumber(lottos, winLotto);
        getResult();
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
        return new WinLotto(winLotto);
    }

    private Lotto getWinLotto() {
        List<Integer> newList = InputView.inputWinLotto()
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(newList);
    }

    private int getBonusBall() {
        return Integer.parseInt(InputView.inputBonusBall());
    }
    public static void findSameNumber(
            Lottos lottos,
            WinLotto winLotto)
    {
        for (int i = 0; i < amount; i++) {
            List<Integer> tempLotto = lottos.getLottoList().get(i).getLotto();
            List<Integer> tempWin = winLotto.getWinLotto().getLotto();
            tempLotto.retainAll(tempWin);
            int same = tempLotto.size();
            sameCnt[same]++;
        }
    }

    public static void getResult() {
        int[] price = {5000, 50000, 1500000, 2000000000};
        double sum = 0;
        for (int i = 3; i <= 6; i++) {
            sum += price[i - 3] * sameCnt[i];
        }
        OutputView.showResultStatistics();
        OutputView.showResult(
                sum,
                sameCnt,
                totalPrice
        );
    }

}
