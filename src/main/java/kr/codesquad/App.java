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
        int autoLottoCount = user.countOfBuying() - manualLottoCount;
        user.setLottos(lottoStore.issueLotto(manualLottoCount));
        ioManager.printLottoCount(manualLottoCount, autoLottoCount);
        ioManager.printLottos(user.getLottos());
        LottoGame lottoGame = new LottoGame(user.getLottos());
        LottoResult result = lottoGame.match(lottoStore.issueWinningLotto());
        result.printResult();
        ioManager.printEarningRate((result.getPrize()-user.getMoney())/(float)user.getMoney());
    }
}
