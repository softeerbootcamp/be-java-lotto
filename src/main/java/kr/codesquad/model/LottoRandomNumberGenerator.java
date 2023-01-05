package kr.codesquad.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoRandomNumberGenerator implements LottoNumberGenerator {

    @Override
    public List<Integer> generate() {
        List<Integer> lottoNumbers = IntStream.rangeClosed(Lotto.MINIMUM_NUMBER, Lotto.MAXIMUM_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, Lotto.NUMBERS_SIZE);
    }
}
