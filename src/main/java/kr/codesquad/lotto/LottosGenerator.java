package kr.codesquad.lotto;

import java.util.List;

public interface LottosGenerator {

    List<Lotto> generate(int money);
}
