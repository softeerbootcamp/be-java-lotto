package kr.codesquad.domain.lotto.factory;

import kr.codesquad.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoFactory implements LottoFactory{

    @Override
    public List<Integer> generateLottoNumbers() {
        return InputView.inputLotto();
    }

}
