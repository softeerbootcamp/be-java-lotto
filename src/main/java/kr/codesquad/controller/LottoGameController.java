package kr.codesquad.controller;

import kr.codesquad.domain.*;
import kr.codesquad.domain.exception.LottoNumberException;
import kr.codesquad.domain.exception.NumberCountException;
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
        Money money = new Money(InputView.inputMoney());

        List<Lotto> lottos = lottoGenerator.generateLottos(money);
        OutputView.printLottos(lottos);

        LottoGame lottoGame = new LottoGame(lottos);
        LottoResult result = lottoGame.match(issueWinningLotto());

        OutputView.printMatchResult(result.getResult());
        OutputView.printEarningRate(result.getEarningRate(money.getMoney()));
    }

    private WinningLotto issueWinningLotto(){
        while (true) {
            try {
                return new WinningLotto(Lotto.ofComma(InputView.inputWinningNumber()), InputView.inputBonusNumber());
            } catch (NumberCountException | LottoNumberException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
