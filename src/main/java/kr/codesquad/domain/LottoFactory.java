package kr.codesquad.domain;

import kr.codesquad.view.IOManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private final List<Integer> numbers;
    private final IOManager ioManager;

    public LottoFactory(IOManager ioManager) {
        this.ioManager = ioManager;
        numbers = new ArrayList<>();
        for (int number = LOTTO_START_NUMBER; number <= LOTTO_LAST_NUMBER; number++) {
            numbers.add(number);
        }
    }

    public Lotto generateLotto(String type) {
        if (type.equals("automatic")) {
            Collections.shuffle(numbers);
            return Lotto.of(numbers.subList(0,6));
        }
        if (type.equals("manual")) {
            return Lotto.ofComma(ioManager.inputManualNumber());
        }
        if (type.equals("winning")){
            return Lotto.ofComma(ioManager.inputWinningNumber());
        }
        throw new IllegalArgumentException("유효하지 않은 로또 종류입니다");
    }
}
