package kr.codesquad;

import java.util.List;

import kr.codesquad.domain.earningRate.EarningRate;
import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.domain.lotto.LottoFactory;
import kr.codesquad.domain.lotto.LottoShop;
import kr.codesquad.domain.winningResult.WinningResult;
import kr.codesquad.io.Console;

public class App implements Runnable {

  private final Console console;
  private final LottoShop lottoShop;

  public App(
      Console console,
      LottoShop lottoShop
  ) {
    this.console = console;
    this.lottoShop = lottoShop;
  }

  @Override
  public void run() {
    int purchaseAmount = console.inputPurchaseAmount();
    List<Lotto> lottos = lottoShop.purchase(purchaseAmount);
    console.printPurchaseCount(lottos.size());

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
