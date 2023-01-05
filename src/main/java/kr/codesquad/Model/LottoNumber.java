package kr.codesquad.Model;

import kr.codesquad.Exception.InvalidLottoNumberException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {
    private static final Map<Integer, LottoNumber> lottoNos = new HashMap<>();
    static {
        for (int i = 1; i < 46; i++) {
            lottoNos.put(i, new LottoNumber(i));
        }
    }

    private final int no;

    private LottoNumber(int no) {
        if (no < 1 || no > 45) {
            throw new InvalidLottoNumberException("로또번호가 아닌데요?\n");
        }

        this.no = no;
    }

    static LottoNumber of(String value) {
        if (Objects.isNull(value)) {
            throw new InvalidLottoNumberException("로또번호가 아닌데요?\n");
        }

        return lottoNos.get(Integer.parseInt(value.trim()));
    }

    public static LottoNumber of(int number) {
        return new LottoNumber(number);
    }

    public int getNo(){
        return this.no;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return no == that.no;
    }

}
