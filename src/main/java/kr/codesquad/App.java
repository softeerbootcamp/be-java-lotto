package kr.codesquad;

import java.util.List;

public class App implements Runnable {

  private final Console console;
  private final WinnerChecker winnerChecker;
  private final LottoNumbersFactory lottoNumbersFactory;

  public App(
      Console console,
      WinnerChecker winnerChecker,
      LottoNumbersFactory lottoNumbersFactory
  ) {
    this.console = console;
    this.winnerChecker = winnerChecker;
    this.lottoNumbersFactory = lottoNumbersFactory;
  }

  public static final int LOTTO_PRICE = 1_000;

  @Override
  public void run() {
    console.printInputAmount();
    int purchaseAmount = console.inputPurchaseAmount();
    int purchaseCount = purchaseAmount / LOTTO_PRICE;
    console.printPurchaseCount(purchaseCount);
    List<LottoNumbers> numbersList = lottoNumbersFactory.generateList(purchaseCount);

    console.printLottoNumbersList(numbersList);
    console.printInputWinningNumber();
    LottoNumbers winningNumber = console.inputWinningNumbers();

    WinningResult winningResult = winnerChecker.check(numbersList, winningNumber);
    console.printWinningResult(winningResult);

    EarningRate earningRate = EarningRate.of(winningResult.getTotalWinningMoney(), purchaseAmount);
    console.printEarningRate(earningRate);
  }

}
