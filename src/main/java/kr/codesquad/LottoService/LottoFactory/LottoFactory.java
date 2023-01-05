package kr.codesquad.LottoService.LottoFactory;

import kr.codesquad.LottoService.Lotto;
import kr.codesquad.View.IOManager;
import kr.codesquad.View.IOManagerImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory{
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final String ILLEGAL_ARGUMENT_MESSAGE = "유효하지 않은 로또 종류입니다";
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
            return Lotto.of(numbers);
        }
        if (type.equals("manual")) {
            return Lotto.ofComma(ioManager.inputManualNumber());
        }
        throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
    }
}
