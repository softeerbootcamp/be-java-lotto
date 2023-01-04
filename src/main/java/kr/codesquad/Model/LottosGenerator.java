package kr.codesquad.Model;

import java.util.List;

public interface LottosGenerator {
    List<Lotto> generate(Money money);
}
