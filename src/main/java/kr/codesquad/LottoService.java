package kr.codesquad;

import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.io.IOException;

public class LottoService {

    private InputView inputView;
    private OutputView outputView;
    private Lotto lotto;

    public LottoService(InputView inputView, OutputView outputView, Lotto lotto) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lotto = lotto;
    }

    public void buyLotto() throws IOException {
        outputView.printInputMoneyText();
        long count = lotto.calculateCount(inputView.inputMoney());
        outputView.printBoughtLottoCount(count);
        outputView.printLottoNumbers(lotto.generateLotto(count));
    }

    public void inputWinningNumber() throws IOException {
        outputView.printWinningNumberText();
        lotto.setWinningNumbers(inputView.inputWinningNumbers());
        outputView.printBonusBallText();
        lotto.updateBonusBall(inputView.inputBonusNumber());
    }

    public void calculateTotal() {
        lotto.calculateTotalResult();
        outputView.printTotalText(lotto.getScore());
        outputView.printEarnedRate(lotto.calculateEarningRate());
    }
}
