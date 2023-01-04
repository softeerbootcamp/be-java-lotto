package kr.codesquad.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import kr.codesquad.domain.lotto.factory.LottoFactory;

public class LottoShop {

  private final LottoFactory lottoFactory;

  private static final int LOTTO_PRICE = 1_000;

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
