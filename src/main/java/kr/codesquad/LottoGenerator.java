package kr.codesquad;

import kr.codesquad.domain.Lotto2;
import kr.codesquad.domain.Money;

import java.util.List;

public interface LottoGenerator {
    List<Lotto2> generate(Money money);
}
