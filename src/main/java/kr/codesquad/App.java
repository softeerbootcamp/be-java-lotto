package kr.codesquad;

import java.util.List;

import kr.codesquad.domain.earningRate.EarningRate;
import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.domain.lotto.LottoFactory;
import kr.codesquad.domain.winningResult.WinningResult;
import kr.codesquad.io.Console;

public class App implements Runnable {

  private final Console console;
  private final LottoFactory lottoFactory;

  public App(
      Console console,
      LottoFactory lottoFactory
  ) {
    this.console = console;
    this.lottoFactory = lottoFactory;
  }

  public static final int LOTTO_PRICE = 1_000;

  @Override
  public void run() {
    console.printInputAmount();
    int purchaseAmount = console.inputPurchaseAmount();
    int purchaseCount = purchaseAmount / LOTTO_PRICE;
    console.printPurchaseCount(purchaseCount);
    List<Lotto> lottos = lottoFactory.generateList(purchaseCount);

    console.printLottoNumbersList(lottos);
    console.printInputWinningNumber();
    Lotto winningNumber = console.inputWinningNumbers();

    WinningResult winningResult = new WinningResult();
    winningResult.calculateResult(lottos, winningNumber);
    console.printWinningResult(winningResult);

    EarningRate earningRate = EarningRate.of(winningResult.getTotalWinningMoney(), purchaseAmount);
    console.printEarningRate(earningRate);
  }

}
