package kr.codesquad.domain.lotto.factory;

import kr.codesquad.domain.lotto.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class RandomLottoFactory implements LottoFactory {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_IDX = 0;
    private static final int LOTTO_SIZE = 6;

    private static final List<LottoNumber> lottoNumbers = new ArrayList<>();

    @Override
    public List<LottoNumber> generateLottoNumbers() {
        initLottoNumbers();
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(LOTTO_MIN_IDX, LOTTO_SIZE);
    }

    public void initLottoNumbers() {
        IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .mapToObj(LottoNumber::new)
                .forEach(lottoNumbers::add);
    }
}
