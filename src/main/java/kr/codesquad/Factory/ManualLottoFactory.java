package kr.codesquad.Factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoFactory implements LottoFactory{

    private static final String DELIMITER = ",";
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> lottoNumbers;

    public ManualLottoFactory(String input) {
        List<Integer> inputNumbers = convertToLottoNumbers(input);
        lottoNumbers = new ArrayList<>(inputNumbers);
    }

    @Override
    public List<Integer> generateLottoNumbers() {
        return lottoNumbers;
    }

    private List<Integer> convertToLottoNumbers(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
