package kr.codesquad.domain.lotto.factory;

import kr.codesquad.domain.lotto.Lotto;

import java.util.List;

public interface LottoFactory {

    List<Lotto> buyLotto(int amount);
}
