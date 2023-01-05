package kr.codesquad;

import kr.codesquad.LottoService.*;
import kr.codesquad.View.IOManager;
import kr.codesquad.View.IOManagerImpl;

public class App {
    private IOManager ioManager;

    public App() {
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
