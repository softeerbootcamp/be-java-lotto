package kr.codesquad.domain.lotto.factory;

import kr.codesquad.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoFactory implements LottoFactory{

    private static final String DELIMITER = ",";

    @Override
    public List<Integer> generateLottoNumbers() {
        return convertToLottoNumbers(InputView.inputManualLotto());
    }

    private List<Integer> convertToLottoNumbers(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
