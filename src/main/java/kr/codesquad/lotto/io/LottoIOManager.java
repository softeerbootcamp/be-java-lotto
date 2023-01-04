package kr.codesquad.lotto.io;

import kr.codesquad.lotto.LottoResult;

import java.util.Set;

public interface LottoIOManager {
    int readPurchasePrice();
    int readLottoCount(String message);
    Set<Integer> readLottoNumberSet(String message);
    int readLottoNumber(String message);

    void print(String message);
    void printLottoResult(LottoResult lottoResult);
}
