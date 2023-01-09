package kr.codesquad.controller;

import kr.codesquad.util.AutoLottoGenerator;
import kr.codesquad.domain.LottoMachine;
import kr.codesquad.domain.*;
import kr.codesquad.util.ManualLottoGenerator;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.io.IOException;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoMachine lottoMachine;

    public LottoController(InputView inputView, OutputView outputView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
    }

    //money 받아오기
    public Money inputMoney() throws IOException {
        outputView.printInputMoneyText();
        Money money = new Money(Money.convertStringToMoney(inputView.inputMoney()));
        return money;
    }

    public Money issueManualLotto(Money money) throws IOException {
        outputView.printMaulLottoBuyText();
        int manualLottoCount = inputView.inputCountOfManualLotto(money);
        money.buyManualLotto(manualLottoCount);
        Money manualLottoMoney = Money.from(manualLottoCount);
        outputView.printManualLottoNumber();
        lottoMachine.issueLotto(manualLottoMoney, new ManualLottoGenerator());
        return manualLottoMoney;
    }

    //로또 초기화 및 발급
    public void issueLotto(Money money, Money manualLottoMoney) {
        lottoMachine.issueLotto(money, new AutoLottoGenerator());
        outputView.printIssuedLottoCount(money, manualLottoMoney);
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
