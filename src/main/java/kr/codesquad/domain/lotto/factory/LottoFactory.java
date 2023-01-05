package kr.codesquad.domain.lotto.factory;

import kr.codesquad.domain.lotto.LottoNumber;

import java.util.List;

public interface LottoFactory {
    List<LottoNumber> generateLottoNumbers();
}
