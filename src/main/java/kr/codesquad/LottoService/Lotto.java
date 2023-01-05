package kr.codesquad.LottoService;

import kr.codesquad.Rank;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    List<Integer> numbers;

    private final Set<LottoNumber> lotto;
    private Lotto(Set<LottoNumber> lotto) {
        if (lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }

        this.lotto = lotto;
    }

    public static Lotto of(List<Integer> numbers) {
        Set<LottoNumber> lotto = new HashSet<>();
        for (Integer number : numbers) {
            lotto.add(LottoNumber.of(number));
        }
        return new Lotto(lotto);
    }

    public static Lotto ofComma(String value) {
        String[] values = value.split(",");
        return new Lotto(
                Arrays.stream(values)
                        .map(LottoNumber::of)
                        .collect(Collectors.toSet()));
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public int match(Lotto target) {
        int count = 0;
        for (LottoNumber lottoNumber : lotto) {
            count += target.increment(lottoNumber);
        }
        return count;
    }

    private int increment(LottoNumber lottoNumber) {
        if (contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }
}
