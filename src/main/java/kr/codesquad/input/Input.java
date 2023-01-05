package kr.codesquad.input;

import kr.codesquad.lotto.LottoNumber;

import java.util.List;

public interface Input {
    int moneyInput();

    int manualLottoCountInput();

    List<LottoNumber> manualLottoNumbersInput();

    List<LottoNumber> jackpotNumberInput();

    int bonusNumberInput();
}
