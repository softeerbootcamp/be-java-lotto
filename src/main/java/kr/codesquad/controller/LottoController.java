package kr.codesquad.controller;

import kr.codesquad.model.Lotto;
import kr.codesquad.model.LottoMachine;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.util.HashMap;
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

        List<Lotto> lottos = lottoMachine.createLottos(lottoCount);

        outputView.printLottos(lottos);

        outputView.printWinningLottoReadMessage();
        Lotto winningLotto = inputView.readWinningLotto();

        Map<Integer, Integer> result = caculateResult(lottos, winningLotto);
        double profitRate = caculateProfitRate(result, money);
        outputView.printResult(result, profitRate);
    }

    private Map<Integer, Integer> caculateResult(List<Lotto> lottos, Lotto winningLotto) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 3; i <= 6; i++){
            result.put(i, 0);
        }

        lottos.forEach(lotto -> {
                int sameCount = lotto.compare(winningLotto);
                if (result.containsKey(sameCount)) {
                    result.put(sameCount, result.get(sameCount)+1);
                }
        });

        return result;
    }

    private double caculateProfitRate(Map<Integer, Integer> result, int money) {
        double profit = 0;
        for (int i = 3; i <= 6; i++){
            profit += (double)i * result.get(i);
        }

        if (profit < money) {
            return -(100 - profit / money * 100);
        }
        return profit / money * 100;
    }
}
