package kr.codesquad.IO;

import kr.codesquad.lotto.LottoNumber;

import java.io.IOException;
import java.util.List;

public interface Input {
    int moneyInput();

    int manualLottoCountInput();

    List<List<LottoNumber>> manualLottoNumbersInput(int count);

    List<LottoNumber> jackpotNumberInput();

    LottoNumber bonusNumberInput();
}
