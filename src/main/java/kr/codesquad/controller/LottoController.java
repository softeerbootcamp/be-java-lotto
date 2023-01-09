package kr.codesquad.controller;

import kr.codesquad.model.LottoMachine;
import kr.codesquad.model.User;
import kr.codesquad.model.WinningResult;
import kr.codesquad.model.lotto.Lotto;
import kr.codesquad.model.lotto.WinningLotto;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoController {

    private final LottoMachine lottoMachine;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.lottoMachine = new LottoMachine();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        int money = createLottoMoney();
        int manualLottoCount = createManualLottoCount(money);

        User user = createUserLotto(money, manualLottoCount);
        outputView.printUser(user);

        WinningLotto winningLotto = createWinningLotto();

        WinningResult winningResult = calculateResult(user, winningLotto);
        outputView.printResult(winningResult, money);
    }

    private int createLottoMoney() {
        outputView.printMoneyReadMessage();
        return inputView.readMoney();
    }

    private int createManualLottoCount(int money) {
        outputView.printManualLottoCountReadMessage();
        return inputView.readManualLottoCount(money);
    }

    private User createUserLotto(int money, int manualLottoCount) {
        int autoLottoCount = money / Lotto.PRICE - manualLottoCount;

        if (manualLottoCount > 0) {
            outputView.printUserManualLottoReadMessage();
        }

        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(createManualLottos(manualLottoCount));
        lottos.addAll(createAutoLottos(autoLottoCount));
        return new User(money, manualLottoCount, autoLottoCount, lottos);
    }

    private List<Lotto> createManualLottos(int manualLottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < manualLottoCount; count++) {
            List<Integer> numbers = inputView.readLottoNumbers();
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    private List<Lotto> createAutoLottos(int autoLottoCount) {
        return lottoMachine.createLottos(autoLottoCount);
    }

    private WinningLotto createWinningLotto() {
        outputView.printWinningLottoReadMessage();
        List<Integer> numbers = inputView.readLottoNumbers();

        outputView.printBonusNumberReadMessage();
        int bonusNumber = inputView.readBonusNumber(numbers);

        return new WinningLotto(new Lotto(numbers), bonusNumber);
    }

    private WinningResult calculateResult(User user, WinningLotto winningLotto) {
        return new WinningResult(user.compare(winningLotto));
    }
}
