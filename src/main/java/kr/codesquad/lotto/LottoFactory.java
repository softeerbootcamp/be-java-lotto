package kr.codesquad.lotto;

import java.util.List;

public interface LottoFactory {

    List<Lotto> buyLotto(int amount);
}
