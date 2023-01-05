package kr.codesquad.domain.lotto;

import java.util.List;

import kr.codesquad.domain.lotto.factory.LottoAutoFactory;
import kr.codesquad.domain.lotto.factory.LottoManualFactory;

public class LottoShop {

  private static final int LOTTO_PRICE = 1_000;

  private static final LottoAutoFactory lottoAutoFactory = new LottoAutoFactory();
  private static final LottoManualFactory lottoManualFactory = new LottoManualFactory();

  public LottoShopPurchaseResult purchase(
      int purchaseMoney,
      int manualLottoCount
  ) {
    if (purchaseMoney < 0 || manualLottoCount < 0) {
      throw new IllegalArgumentException("잘못된 구매 정보입니다.");
    }
    int totalLottoCount = getPurchaseLottoCount(purchaseMoney);
    int autoLottoCount = getAutoLottoCount(totalLottoCount, manualLottoCount);

    List<Lotto> autoLottos = lottoAutoFactory.generate(autoLottoCount);
    List<Lotto> manualLottos = lottoManualFactory.generate(manualLottoCount);
    return LottoShopPurchaseResult.of(autoLottos, manualLottos, calculateTotalPrice(autoLottoCount, manualLottoCount));
  }

  private int getPurchaseLottoCount(int money) {
    return money / LOTTO_PRICE;
  }

  private int getAutoLottoCount(
      int totalLottoCount,
      int manualLottoCount
  ) {
    if (totalLottoCount < manualLottoCount) {
      throw new IllegalArgumentException("잘못된 구매 정보 입니다");
    }
    return totalLottoCount - manualLottoCount;
  }

  private int calculateTotalPrice(
      int autoPurchaseCount,
      int manualPurchaseCount
  ) {
    int totalCount = autoPurchaseCount + manualPurchaseCount;
    return totalCount * LOTTO_PRICE;
  }

}
