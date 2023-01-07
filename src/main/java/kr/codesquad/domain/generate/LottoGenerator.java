package kr.codesquad.domain.generate;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.Money;

import java.util.List;

public interface LottoGenerator {
    List<Lotto> generateLottos(Money money);
}
