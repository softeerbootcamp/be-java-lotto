package kr.codesquad.domain.lotto.factory;

import kr.codesquad.domain.lotto.Lotto;

public interface LottoFactory {

  int LOTTO_NUMBER_BOUND = 45;
  int LOTTO_NUMBER_COUNT = 6;

  Lotto generate();

}
