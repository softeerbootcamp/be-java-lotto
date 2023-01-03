package kr.codesquad;

import java.util.List;

import kr.codesquad.domain.earningRate.EarningRate;
import kr.codesquad.domain.lotto.Lotto;
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
    int purchaseMoney = console.inputPurchaseMoney();
    List<Lotto> lottos = purchaseLotto(purchaseMoney);

    Lotto winningNumber = console.inputWinningNumbers();
    WinningResult winningResult = WinningResult.createResult(lottos, winningNumber);
    console.printWinningResult(winningResult);

    EarningRate earningRate = EarningRate.of(winningResult.getTotalWinningMoney(), purchaseMoney);
    console.printEarningRate(earningRate);
  }

  private List<Lotto> purchaseLotto(int money) {
    List<Lotto> lottos = lottoShop.purchase(money);
    console.printPurchaseCount(lottos.size());
    console.printLottoNumbersList(lottos);
    return lottos;
  }

}
