package kr.codesquad.LottoService.LottoFactory;

import kr.codesquad.LottoService.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory{
    private List<Integer> numbers;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final String ILLEGAL_ARGUMENT_MESSAGE = "유효하지 않은 로또 종류입니다";
    public LottoFactory() {
        numbers = new ArrayList<>();
        for (int number = LOTTO_START_NUMBER; number <= LOTTO_LAST_NUMBER; number++) {
            numbers.add(number);
        }
    }

    public Lotto generateLotto(String type) {
        if (type.equals("automatic")) {
            Collections.shuffle(numbers);
//            return new Lotto(new ArrayList<>(numbers.subList(0, LOTTO_SIZE)));
            return null;
        }
        if (type.equals("manual")) {
            return null;
        }
        throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
    }
}
