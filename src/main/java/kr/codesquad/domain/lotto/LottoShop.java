package kr.codesquad.domain.lotto;

import java.util.ArrayList;
import java.util.List;

import kr.codesquad.domain.lotto.factory.LottoAutoFactory;
import kr.codesquad.domain.lotto.factory.LottoManualFactory;

public class LottoShop {

  public List<Lotto> purchase(
      int autoPurchaseCount,
      int manualPurchaseCount
  ) {
    List<Lotto> result = new ArrayList<>();
    result.addAll(new LottoAutoFactory().generate(autoPurchaseCount));
    result.addAll(new LottoManualFactory().generate(manualPurchaseCount));

    return result;
  }

}
