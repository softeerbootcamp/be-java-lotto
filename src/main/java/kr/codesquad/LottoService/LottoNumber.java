package kr.codesquad.LottoService;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {
    private static final Map<Integer, LottoNumber> lottoNos = new HashMap<>();
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    static {
        for (int i = LOTTO_START_NUMBER; i <= LOTTO_END_NUMBER; i++) {
            lottoNos.put(i, new LottoNumber(i));
        }
    }

    private final int no;

    private LottoNumber(int no) {
        if (no < LOTTO_START_NUMBER || no > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException();
        }

        this.no = no;
    }

    static LottoNumber of(String value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException();
        }

        return lottoNos.get(Integer.parseInt(value.trim()));
    }
    static LottoNumber of(int number) {
        return new LottoNumber(number);
    }

}
