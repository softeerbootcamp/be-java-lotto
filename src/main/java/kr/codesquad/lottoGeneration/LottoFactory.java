package kr.codesquad.lottoGeneration;

import kr.codesquad.exception.DuplicateLottoNumberException;
import kr.codesquad.lotto.Lotto;

import java.util.List;

public interface LottoFactory {
    List<Lotto> generate(int count) throws DuplicateLottoNumberException;
}
