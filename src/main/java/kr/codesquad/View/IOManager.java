package kr.codesquad.View;

import kr.codesquad.LottoService.Lotto;

import java.util.List;

public interface IOManager {
    int inputMoney();
    int inputManualLottoCount();

    String inputWinningNumber();

    String inputManualNumber();

    int inputBonusNumber();
    void printLottoCount(int lottoAutoCount, int lottoManualCount);
    void printEarningRate(float earningRate);

    void printLottos(List<Lotto> lottos);
}
