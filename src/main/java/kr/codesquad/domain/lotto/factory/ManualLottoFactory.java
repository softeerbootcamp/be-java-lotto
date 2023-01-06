package kr.codesquad.domain.lotto.factory;

import kr.codesquad.domain.lotto.LottoNumber;
import kr.codesquad.view.InputView;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoFactory implements LottoFactory {

    private static final int COUNT = 6;

    @Override
    public List<LottoNumber> generateLottoNumbers() {
        List<LottoNumber> lottoNumbers = convertToLottoNumber();
        checkNumbers(lottoNumbers);
        return lottoNumbers;
    }

    private List<LottoNumber> convertToLottoNumber() {
        List<Integer> lottoNumbers = InputView.inputLotto();
        return lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void checkNumbers(List<LottoNumber> inputNumbers) {
        if (inputNumbers.size() != COUNT) {
            throw new IllegalArgumentException("로또 숫자를 6개 입력해 주세요.");
        }
        if (inputNumbers.stream().distinct().count() != COUNT) {
            throw new IllegalArgumentException("중복된 로또 번호가 있습니다.");
        }
    }

}
