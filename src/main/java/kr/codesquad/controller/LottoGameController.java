package kr.codesquad.controller;

import kr.codesquad.domain.*;
import kr.codesquad.view.IOManager;
import kr.codesquad.view.IOManagerImpl;

public class LottoGameController {
    private IOManager ioManager;

    public LottoGameController() {
        ioManager = new IOManagerImpl();
    }

    public void play(){
        User user = new User(ioManager.inputMoney());
        LottoIssue lottoIssue = new LottoIssue(user, new LottoFactory(ioManager), ioManager);
        int manualLottoCount = ioManager.inputManualLottoCount();
        LottoGame lottoGame = new LottoGame(lottoIssue.issueLotto(manualLottoCount));
        LottoResult result = lottoGame.match(lottoIssue.issueWinningLotto());
        ioManager.printMatchResult(result.getResult());
        ioManager.printEarningRate(result.getEarningRate(user.getMoney()));
    }
}
