package kr.codesquad.lotto;

import kr.codesquad.exception.DuplicateLottoNumberException;

import java.util.Collections;
import java.util.List;

public class Lotto {
    public static int PRICE = 1000;

    public static int NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> list) throws DuplicateLottoNumberException {
        if(!verify(list)) {
            throw new DuplicateLottoNumberException();
        }
        lottoNumbers = list;
    }

    public static Lotto of(List<LottoNumber> list) {
        return new Lotto(list);
    }

    private boolean verify(List<LottoNumber> list) {
        for(LottoNumber lottoNumber : list) {
            if (Collections.frequency(list, lottoNumber) != 1 || list.size() != Lotto.NUMBER_COUNT) {
                return false;
            }
        }
        return true;
    }

    public int contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber) ? 1 : 0;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
