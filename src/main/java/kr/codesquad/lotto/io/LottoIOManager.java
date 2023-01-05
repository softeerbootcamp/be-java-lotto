package kr.codesquad.lotto.io;

import kr.codesquad.lotto.LottoNumber;
import kr.codesquad.lotto.WinningLotto;

import java.util.Set;

public interface LottoIOManager {
    int readPurchasePrice();
    int readLottoCount(String message);
    Set<LottoNumber> readLottoNumberSet(String message);
    LottoNumber readLottoNumber(String message);
    WinningLotto readWinningLottoNumber();
    void print(String message);
}
