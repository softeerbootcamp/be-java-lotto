package kr.codesquad.domain.lotto;

import static kr.codesquad.domain.lotto.Lotto.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import kr.codesquad.domain.lotto.factory.LottoFactory;

public class LottoShop {

  private final LottoFactory lottoFactory;

  public LottoShop(LottoFactory lottoFactory) {
    this.lottoFactory = lottoFactory;
  }

  public List<Lotto> purchase(int money) {
    int purchaseCount = money / LOTTO_PRICE;
    return IntStream.range(0, purchaseCount)
                    .mapToObj(i -> lottoFactory.generate())
                    .collect(Collectors.toCollection(ArrayList::new));
  }

}
