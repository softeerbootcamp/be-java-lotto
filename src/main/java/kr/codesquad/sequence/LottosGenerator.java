package kr.codesquad.sequence;

import kr.codesquad.Lotto;
import kr.codesquad.Money;

import java.util.List;

public interface LottosGenerator {
    int LOTTO_LENGTH = 6;  // 로또 번호 조합의 길이

    List<Lotto> generate(final int ticketsToGenerate);

}
