package kr.codesquad.lotto;

import java.util.List;

public class Lotto {
    public static int PRICE = 1000;

    public static int NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> list) {
        lottoNumbers = list;
    }

    public static Lotto of(List<LottoNumber> list) {
        return new Lotto(list);
    }

    public int contains(List<LottoNumber> lottoNumbers) {
        int count = 0;
        for(LottoNumber lottoNumber : lottoNumbers) {
            count += this.lottoNumbers.contains(lottoNumber) ? 1 : 0;
        }
        return count;
    }

    public boolean containsBonus(int bonus) {
        return this.lottoNumbers.contains(LottoNumber.of(bonus));
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
