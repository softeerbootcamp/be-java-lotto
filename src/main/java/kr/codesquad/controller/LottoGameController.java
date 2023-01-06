package kr.codesquad.controller;

import kr.codesquad.domain.*;
import kr.codesquad.domain.generate.LottoGenerator;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.util.List;

public class LottoGameController {
    private final LottoGenerator lottoGenerator;

    public LottoGameController(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public void play(){
        User user = new User(InputView.inputMoney());

        List<Lotto> lottos = lottoGenerator.generateLottos(user.getMoney());
        OutputView.printLottos(lottos);

        LottoGame lottoGame = new LottoGame(lottos);
        LottoResult result = lottoGame.match(issueWinningLotto());

        OutputView.printMatchResult(result.getResult());
        OutputView.printEarningRate(result.getEarningRate(user.getMoney()));
    }

    private WinningLotto issueWinningLotto(){
        return new WinningLotto(Lotto.ofComma(InputView.inputWinningNumber()), InputView.inputBonusNumber());
    }
}
