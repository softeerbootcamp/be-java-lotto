package kr.codesquad;

import java.util.List;
import java.util.Map;

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

    Map<Integer, Integer> check = winnerChecker.check(numbersList, winningNumber);

    System.out.println(check.toString());

  }

}
