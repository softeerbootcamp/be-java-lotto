package kr.codesquad.controller;

import kr.codesquad.domain.*;
import kr.codesquad.view.IOManager;
import kr.codesquad.view.IOManagerImpl;

public class LottoGameController {
    private IOManager ioManager;

    public LottoGameController() {
        ioManager = new IOManagerImpl();
    }

    public void run(){
        User user = new User(ioManager.inputMoney());
        LottoStore lottoStore = new LottoStore(user, new LottoFactory(ioManager), ioManager);
        int manualLottoCount = ioManager.inputManualLottoCount();
        LottoGame lottoGame = new LottoGame(lottoStore.issueLotto(manualLottoCount));
        LottoResult result = lottoGame.match(lottoStore.issueWinningLotto());
        result.printResult();
        ioManager.printEarningRate((result.getPrize()-user.getMoney())/(float)user.getMoney());
    }
}
