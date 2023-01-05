package kr.codesquad.controller;

import kr.codesquad.domain.*;
import kr.codesquad.view.IOManager;
import kr.codesquad.view.IOManagerImpl;

import java.util.List;

public class LottoGameController {
    private IOManager ioManager;

    public LottoGameController() {
        ioManager = new IOManagerImpl();
    }

    public void play(){
        User user = new User(ioManager.inputMoney());
        LottoIssue lottoIssue = new LottoIssue(new LottoFactory(ioManager), ioManager);
        int manualLottoCount = ioManager.inputManualLottoCount();
        int autoLottoCount = user.countOfBuying() - manualLottoCount;
        List<Lotto> lottos = issueLottoTickets(manualLottoCount, autoLottoCount, lottoIssue);
        LottoGame lottoGame = new LottoGame(lottos);
        LottoResult result = lottoGame.match(lottoIssue.issueWinningLotto());
        ioManager.printMatchResult(result.getResult());
        ioManager.printEarningRate(result.getEarningRate(user.getMoney()));
    }

    private List<Lotto> issueLottoTickets (int manualLottoCount, int autoLottoCount, final LottoIssue lottoIssue){
        List<Lotto> issuedLottos = lottoIssue.issueLotto(manualLottoCount, autoLottoCount);
        ioManager.printLottoCount(autoLottoCount, manualLottoCount);
        ioManager.printLottos(issuedLottos);
        return issuedLottos;
    }
}
