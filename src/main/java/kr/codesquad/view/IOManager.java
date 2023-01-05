package kr.codesquad.view;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.Rank;

import java.util.List;
import java.util.Map;

public interface IOManager {
    int inputMoney();
    int inputManualLottoCount();

    String inputWinningNumber();

    String inputManualNumber();

    int inputBonusNumber();
    void printLottoCount(int lottoAutoCount, int lottoManualCount);
    void printEarningRate(double earningRate);
    void printLottos(List<Lotto> lottos);
    void printMatchResult(Map<Rank, Integer> result);


}
