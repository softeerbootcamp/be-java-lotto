package kr.codesquad.lotto.factory;

import kr.codesquad.lotto.Lotto;

import java.util.List;

public interface LottoFactory {

    List<Lotto> buyLotto(int amount);
}
