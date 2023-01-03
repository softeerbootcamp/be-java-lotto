package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_SIZE = 6;

    List<Integer> lotto = new ArrayList<>();

    public Lotto() {

    }

    private static List<Integer> generateNumbers() {
        return IntStream.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getLotto() {
        return lotto;
    }

}
