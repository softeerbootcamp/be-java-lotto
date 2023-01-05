package kr.codesquad.input;

import kr.codesquad.lotto.LottoNumber;

import java.util.List;

public interface Input {
    int MoneyInput();

    int ManualLottoCountInput();

    List<LottoNumber> ManualLottoNumbersInput();

    List<LottoNumber> JackpotNumberInput();

    int BonusNumberInput();
}
