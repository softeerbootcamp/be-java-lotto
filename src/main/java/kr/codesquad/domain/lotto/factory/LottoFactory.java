package kr.codesquad.domain.lotto.factory;

import java.util.List;

import kr.codesquad.domain.lotto.Lotto;

public interface LottoFactory {

  List<Lotto> generate(int count);

}
