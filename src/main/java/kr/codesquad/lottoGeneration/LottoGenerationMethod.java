package kr.codesquad;

import kr.codesquad.lotto.Lotto;

import java.util.List;

public interface LottoGenerationMethod {
    List<Lotto> realGenerate(int count);
}
