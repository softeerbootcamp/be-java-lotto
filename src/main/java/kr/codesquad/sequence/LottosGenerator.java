package kr.codesquad.sequence;

import kr.codesquad.Lotto;
import kr.codesquad.Money;

import java.util.List;

public interface LottosGenerator {
    List<Lotto> generate(Money money);
}
