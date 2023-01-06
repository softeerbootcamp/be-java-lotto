package kr.codesquad;

import kr.codesquad.domain.LottoNumber;
import kr.codesquad.domain.Row;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoGenerator implements LottoGenerator {

    @Override
    public Row generateRow() {
        List<Integer> randomNumberList = createSeed();
        Collections.shuffle(randomNumberList);
        List<Integer> generatedNums = randomNumberList.subList(0, 6);
        Collections.sort(generatedNums);

        List<LottoNumber> LottoNumbers = generatedNums.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return Row.createRow(LottoNumbers);
    }

    private static List<Integer> createSeed() {
        return IntStream.range(1, 45).boxed().collect(Collectors.toList());
    }
}
