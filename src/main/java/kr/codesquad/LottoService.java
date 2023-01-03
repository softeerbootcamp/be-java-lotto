package kr.codesquad;

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

    public void inputWinningNumber() throws IOException{
        outputView.printWinningNumberText();
        lotto.setWinningNumbers(inputView.inputWinningNumbers());
    }
    public void calculateTotal() {
        lotto.calculateTotalResult();
        outputView.printTotalText(lotto.getResultIndex(), lotto.getResult());
        outputView.printEarnedRate(lotto.calculateEarningRate());
    }
}
