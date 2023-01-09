package kr.codesquad.model;

import kr.codesquad.model.lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoRandomNumberGenerator implements LottoNumberGenerator {

    private static final List<Integer> lottoNumbers = IntStream.rangeClosed(Lotto.MINIMUM_NUMBER, Lotto.MAXIMUM_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>(lottoNumbers);
        Collections.shuffle(numbers);
        return numbers.subList(0, Lotto.NUMBERS_SIZE);
    }
}
