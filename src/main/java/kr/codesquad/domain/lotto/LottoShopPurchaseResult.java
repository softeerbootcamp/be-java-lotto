package kr.codesquad.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoShopPurchaseResult {

  private final List<Lotto> autoLottos;
  private final List<Lotto> manualLotto;
  private final int totalPrice;

  public LottoShopPurchaseResult(
      List<Lotto> autoLottos,
      List<Lotto> manualLotto,
      int totalPrice
  ) {
    this.autoLottos = autoLottos;
    this.manualLotto = manualLotto;
    this.totalPrice = totalPrice;
  }

  public List<Lotto> getAutoLottos() {
    return autoLottos;
  }

  public List<Lotto> getManualLotto() {
    return manualLotto;
  }

  public List<Lotto> getAllLotto() {
    List<Lotto> lottos = new ArrayList<>();
    lottos.addAll(autoLottos);
    lottos.addAll(manualLotto);
    return lottos;
  }


  public int getTotalPrice() {
    return totalPrice;
  }

  public static LottoShopPurchaseResult of(
      List<Lotto> autoLottos,
      List<Lotto> manualLotto,
      int totalPrice
  ) {
    return new LottoShopPurchaseResult(autoLottos, manualLotto, totalPrice);
  }

}
