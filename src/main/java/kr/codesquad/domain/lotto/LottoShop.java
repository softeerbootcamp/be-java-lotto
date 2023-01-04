package kr.codesquad.domain.lotto;

import java.util.List;

import kr.codesquad.domain.lotto.factory.LottoAutoFactory;
import kr.codesquad.domain.lotto.factory.LottoManualFactory;

import kr.codesquad.domain.lotto.factory.LottoFactory;

public class LottoShop {

  private static final LottoAutoFactory lottoAutoFactory = new LottoAutoFactory();
  private static final LottoManualFactory lottoManualFactory = new LottoManualFactory();

  public LottoShopPurchaseResult purchase(
      int autoPurchaseCount,
      int manualPurchaseCount
  ) {
    List<Lotto> autoLottos = lottoAutoFactory.generate(autoPurchaseCount);
    List<Lotto> manualLottos = lottoManualFactory.generate(manualPurchaseCount);
    int totalPrice = calculateTotalPrice(autoPurchaseCount, manualPurchaseCount);
    return LottoShopPurchaseResult.of(autoLottos, manualLottos, totalPrice);
  }

  private int calculateTotalPrice(
      int autoPurchaseCount,
      int manualPurchaseCount
  ) {
    int totalCount = autoPurchaseCount + manualPurchaseCount;
    return totalCount * Lotto.LOTTO_PRICE;
  }

}
