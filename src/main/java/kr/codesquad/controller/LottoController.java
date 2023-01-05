package kr.codesquad.controller;

import kr.codesquad.model.*;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
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
        User user = createUserWithMoneyAndLottoCount();
        outputView.printUser(user);

        WinningLotto winningLotto = createWinningLotto();

        Map<Rank, Integer> result = calculateResult(user, winningLotto);
        double profitRate = calculateProfitRate(result, user.getPurchaseMoney());
        outputView.printResult(result, profitRate);
    }

    private User createUserWithMoneyAndLottoCount() {
        int money = createLottoMoney();
        int manualLottoCount = createManualLottoCount(money);
        int autoLottoCount = money / Lotto.PRICE - manualLottoCount;

        outputView.printUserManualLottoReadMessage();

        List<Lotto> lottos = new ArrayList<>();
        createManualLottos(manualLottoCount, lottos);
        createAutoLottos(autoLottoCount, lottos);
        return new User(money, manualLottoCount, autoLottoCount, lottos);
    }

    private int createLottoMoney() {
        outputView.printMoneyReadMessage();
        return inputView.readMoney();
    }

    private int createManualLottoCount(int money) {
        outputView.printManualLottoCountReadMessage();
        return inputView.readManualLottoCount(money);
    }

    private void createManualLottos(int manualLottoCount, List<Lotto> lottos) {
        for (int count = 0; count < manualLottoCount; count++) {
            List<Integer> numbers = inputView.readLottoNumbers();
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
    }

    private void createAutoLottos(int autoLottoCount, List<Lotto> lottos) {
        lottos.addAll(lottoMachine.createLottos(autoLottoCount));
    }

    private WinningLotto createWinningLotto() {
        outputView.printWinningLottoReadMessage();
        List<Integer> numbers = inputView.readLottoNumbers();

        outputView.printBonusNumberReadMessage();
        int bonusNumber = inputView.readBonusNumber(numbers);

        return new WinningLotto(numbers, bonusNumber);
    }

    private Map<Rank, Integer> calculateResult(User user, WinningLotto winningLotto) {
        return user.compare(winningLotto);
    }

    private double calculateProfitRate(Map<Rank, Integer> result, int money) {
        double profit = result.entrySet()
                .stream()
                .map(entry ->
                        entry.getKey().getPrize() * entry.getValue())
                .reduce(0, Integer::sum);

        return (profit - money) / money * 100;
    }
}
