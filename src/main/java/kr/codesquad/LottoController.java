package kr.codesquad;

import kr.codesquad.domain.*;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.io.IOException;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoMachine lottoMachine;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    //money 받아오기
    public Money inputMoney() throws IOException {
        outputView.printInputMoneyText();
        Money money = new Money(Money.convertStringToMoney(inputView.inputMoney()));
        outputView.printIssuedLottoCount(money);
        return money;
    }

    //로또 초기화 및 발급
    public void issueLotto(Money money) {
        //여기서 이제 정해지지 어떤 generator 가 될지
        //여기서 new Generator
        lottoMachine = new LottoMachine(money, new AutoLottoGenerator());
        outputView.printString(lottoMachine.lottosToString());
    }

    public WinningLotto inputWinningLotto() throws IOException {
        outputView.printWinningNumberText();
        Lotto lotto = inputView.inputWinningLotto();
        outputView.printBonusBallText();
        int bonus = inputView.inputBonusNumber();
        return new WinningLotto(lotto, bonus);
    }

    //결과 출력
    public void printResult(WinningLotto winningLotto, Money money) {
        LottoResult lottoResult = lottoMachine.calculateResult(winningLotto);
        outputView.printString(lottoResult.statisticToString());
        outputView.printString(lottoResult.earnedRateToString(money));
    }
}
