package kr.codesquad.lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber {
    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 1;
    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    static {
        for (int i = 1; i <= MAX_NUMBER; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private final int number;

    private LottoNumber(int number)
    {
        if(number > MAX_NUMBER || number < MIN_NUMBER)
        {
            throw new IllegalArgumentException("범위 밖에 있는 입력입니다");
        }
        this.number = number;
    }

    public static LottoNumber of(String number)
    {
        return lottoNumbers.get(Integer.parseInt(number));
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
