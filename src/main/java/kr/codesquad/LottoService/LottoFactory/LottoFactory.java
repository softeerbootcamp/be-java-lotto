package kr.codesquad.LottoService.LottoFactory;

import kr.codesquad.LottoService.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory{
    private List<Integer> numbers;
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final String ILLEGALARGUMENT_MESSAGE = "유효하지 않은 로또 종류입니다";
    private static final String AUTOMATIC = "automatic";
    private static final String MANUAL = "manual";
    public LottoFactory() {
        numbers = new ArrayList<>();
        for (int number = LOTTO_START_NUMBER; number <= LOTTO_LAST_NUMBER; number++) {
            numbers.add(number);
        }
    }

    public Lotto generateLotto(String type) {
        if (type.equals(AUTOMATIC)) {
            Collections.shuffle(numbers);
            return new Lotto(new ArrayList<>(numbers.subList(0, LOTTO_SIZE)));
        }
        if (type.equals(MANUAL)) {
            return null;
        }
        throw new IllegalArgumentException(ILLEGALARGUMENT_MESSAGE);
    }
}
