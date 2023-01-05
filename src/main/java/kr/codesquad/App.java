package kr.codesquad;

import java.util.List;

import kr.codesquad.domain.earningRate.EarningRate;
import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.domain.lotto.LottoShop;
import kr.codesquad.domain.winningLotto.WinningLotto;
import kr.codesquad.domain.winningLotto.WinningResult;
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
    List<Lotto> lottos = purchaseLotto();
    int totalPurchasedLottoPrice = lottos.size() * Lotto.LOTTO_PRICE;
    console.printInputManualLottoNumbers();

    WinningLotto winningLotto = inputWinningLotto();
    WinningResult winningResult = WinningResult.createResult(lottos, winningLotto);
    console.printWinningResult(winningResult);

    EarningRate earningRate = EarningRate.of(winningResult.getTotalWinningMoney(), totalPurchasedLottoPrice);
    console.printEarningRate(earningRate);
  }

  private List<Lotto> purchaseLotto() {
    int purchaseMoney = console.inputPurchaseMoney();
    int manualLottoCount = console.inputManualLottoPurchaseCount();

    int totalLottoCount = purchaseMoney / Lotto.LOTTO_PRICE;
    int autoLottoCount = totalLottoCount - manualLottoCount;

    return lottoShop.purchase(autoLottoCount, manualLottoCount);
  }

  private WinningLotto inputWinningLotto() {
    List<Integer> winningNumbers = console.inputWinningNumbers();
    Lotto winningLottoNumbers = Lotto.from(winningNumbers);
    int bonusNumber = console.inputBonusNumber();
    return new WinningLotto(winningLottoNumbers, bonusNumber);
  }

}
