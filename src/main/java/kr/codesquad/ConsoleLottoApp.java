package kr.codesquad;

import java.util.List;

import kr.codesquad.common.io.Console;
import kr.codesquad.domain.earningRate.EarningRate;
import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.domain.lotto.LottoShop;
import kr.codesquad.domain.lotto.LottoShopPurchaseResult;
import kr.codesquad.domain.winningLotto.WinnerLotto;
import kr.codesquad.domain.winningLotto.RankResult;

public class ConsoleLottoApp extends App {

  private static final Console console = new Console();
  private static final LottoShop lottoShop = new LottoShop();

  @Override
  public void execute() {
    LottoShopPurchaseResult response = purchaseLotto();
    console.printPurchaseResult(response);

    WinnerLotto winnerLotto = inputWinningLotto();
    RankResult rankResult = RankResult.createResult(response.getAllLotto(), winnerLotto);
    console.printWinningResult(rankResult);

    EarningRate earningRate = EarningRate.of(rankResult.getTotalWinningMoney(), response.getTotalPrice());
    console.printEarningRate(earningRate);
  }

  private LottoShopPurchaseResult purchaseLotto() {
    int purchaseMoney = console.inputPurchaseMoney();
    int manualLottoCount = console.inputManualLottoPurchaseCount();

    int totalLottoCount = purchaseMoney / Lotto.LOTTO_PRICE;
    int autoLottoCount = totalLottoCount - manualLottoCount;

    return lottoShop.purchase(autoLottoCount, manualLottoCount);
  }

  private WinnerLotto inputWinningLotto() {
    List<Integer> winningNumbers = console.inputWinningNumbers();
    Lotto winningLottoNumbers = Lotto.from(winningNumbers);
    int bonusNumber = console.inputBonusNumber();
    return new WinnerLotto(winningLottoNumbers, bonusNumber);
  }

}
