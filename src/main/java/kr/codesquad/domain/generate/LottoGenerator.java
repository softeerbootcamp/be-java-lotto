package kr.codesquad.domain.generate;

import kr.codesquad.domain.Lotto;

import java.util.List;

public interface LottoGenerator {
    List<Lotto> generateLottos(int money);
}
