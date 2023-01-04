package kr.codesquad.controller;

import kr.codesquad.model.*;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {

    private final LottoMachine lottoMachine;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.lottoMachine = new LottoMachine();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        int money = createLottoMoney();

        outputView.printManualLottoCountReadMessage();
        int manualLottoCount = inputView.readOneNumber();
        int autoLottoCount = money / 1000 - manualLottoCount;

        outputView.printUserManualLottoReadMessage();
        UserLotto userLotto = createUserLotto(manualLottoCount, autoLottoCount);
        outputView.printLottoCount(manualLottoCount, autoLottoCount);
        outputView.printUserLotto(userLotto);

        WinningLotto winningLotto = createWinningLotto();

        Map<Rank, Integer> result = calculateResult(userLotto, winningLotto);
        double profitRate = calculateProfitRate(result, money);
        outputView.printResult(result, profitRate);
    }

    private int createLottoMoney() {
        outputView.printMoneyReadMessage();
        return inputView.readOneNumber();
    }

    private UserLotto createUserLotto(int manualLottoCount, int autoLottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < manualLottoCount; count++) {
            lottos.add(new Lotto(inputView.readLottoNumbers()));
        }
        lottos.addAll(lottoMachine.createLottos(autoLottoCount));
        return new UserLotto(lottos);
    }

    private WinningLotto createWinningLotto() {
        outputView.printWinningLottoReadMessage();
        List<Integer> numbers = inputView.readLottoNumbers();

        outputView.printBonusNumberReadMessage();
        int bonusNumber = inputView.readOneNumber();

        return new WinningLotto(numbers, bonusNumber);
    }

    private Map<Rank, Integer> calculateResult(UserLotto userLotto, WinningLotto winningLotto) {
        return userLotto.compare(winningLotto);
    }

    private double calculateProfitRate(Map<Rank, Integer> result, int money) {
        double profit = 0;
        for (Rank rank : result.keySet()) {
            profit += rank.getPrize() * result.get(rank);
        }

        if (profit < money) {
            return -(100 - profit / money * 100);
        }
        return profit / money * 100;
    }
}
