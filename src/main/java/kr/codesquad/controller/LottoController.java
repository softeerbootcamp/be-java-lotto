package kr.codesquad.controller;

import kr.codesquad.model.*;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

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
        outputView.printMoneyReadMessage();
        int money = inputView.readMoney();

        int lottoCount = money / 1000;
        outputView.printLottoCount(lottoCount);

        UserLotto userLotto = createUserLotto(lottoCount);

        outputView.printUserLotto(userLotto);

        outputView.printWinningLottoReadMessage();
        WinningLotto winningLotto = createWinningLotto();

        Map<Rank, Integer> result = caculateResult(userLotto, winningLotto);
        //double profitRate = caculateProfitRate(result, money);
        //outputView.printResult(result, profitRate);
    }

    private UserLotto createUserLotto(int lottoCount) {
        List<Lotto> lottos = lottoMachine.createLottos(lottoCount);
        return new UserLotto(lottos);
    }

    private WinningLotto createWinningLotto() {
        Lotto winningLotto = inputView.readWinningLotto();
        int bonusNumber = inputView.readBonusNumber();

        return new WinningLotto(winningLotto, bonusNumber);
    }

    private Map<Rank, Integer> caculateResult(UserLotto userLotto, WinningLotto winningLotto) {
        return userLotto.compare(winningLotto);
    }

    private double caculateProfitRate(Map<Rank, Integer> result, int money) {
        double profit = 0;
        for (int i = 3; i <= 6; i++) {
            profit += (double) i * result.get(i);
        }

        if (profit < money) {
            return -(100 - profit / money * 100);
        }
        return profit / money * 100;
    }
}
