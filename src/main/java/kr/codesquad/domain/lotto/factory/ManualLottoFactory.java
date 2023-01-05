package kr.codesquad.domain.lotto.factory;

import kr.codesquad.domain.lotto.LottoNumber;
import kr.codesquad.view.InputView;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoFactory implements LottoFactory {

    @Override
    public List<LottoNumber> generateLottoNumbers() {
        return convertToLottoNumber();
    }

    private List<LottoNumber> convertToLottoNumber() {
        List<Integer> lottoNumbers = InputView.inputLotto();
        return lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

}
