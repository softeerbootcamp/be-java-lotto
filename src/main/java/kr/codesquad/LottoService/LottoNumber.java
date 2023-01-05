package kr.codesquad.LottoService;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
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
            throw new IllegalArgumentException("유효한 범위 내의 로또 넘버가 아닙니다.");
        }

        this.no = no;
    }

    static LottoNumber of(String value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException("비어있는 로또넘버가 존재합니다.");
        }
        try {
            return lottoNos.get(Integer.parseInt(value.trim()));
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("로또 인자로는 숫자만 가능합니다.");
        }
    }
    static LottoNumber of(int number) {
        return new LottoNumber(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return no == that.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }

    @Override
    public String toString() {
        return String.valueOf(no);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.no - o.no;
    }
}
