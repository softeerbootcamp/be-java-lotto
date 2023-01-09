package kr.codesquad.domain;

import kr.codesquad.domain.exception.LottoNumberException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final Map<Integer, LottoNumber> cachedLottoNum = new HashMap<>();
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    static {
        for (int i = LOTTO_START_NUMBER; i <= LOTTO_END_NUMBER; i++) {
            cachedLottoNum.put(i, new LottoNumber(i));
        }
    }

    private final int number;

    private LottoNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    public static LottoNumber of(String value) {
        if (Objects.isNull(value)) {
            throw new LottoNumberException(value);
        }
        try {
            int key = Integer.parseInt(value.trim());
            validateNumberRange(key);
            return cachedLottoNum.get(Integer.parseInt(value.trim()));
        }
        catch (NumberFormatException e){
            throw new LottoNumberException(value);
        }
    }
    public static LottoNumber of(int number) {
        validateNumberRange(number);
        return cachedLottoNum.get(number);
    }

    static void validateNumberRange(int number){
        if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER)
            throw new LottoNumberException(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }
}
