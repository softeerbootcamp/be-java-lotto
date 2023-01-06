package kr.codesquad;

import kr.codesquad.Lotto.Lotto;
import kr.codesquad.Lotto.LottoStat;
import kr.codesquad.Lotto.WinLotto;
import kr.codesquad.UI.WindowManager;

import java.util.ArrayList;
import java.util.List;


public class VisualLottoGame {
    WindowManager windowManager;
    private final List<Lotto> lottos;
    private WinLotto winLotto;
    private int nTotalLotto;
    private int nManualLotto;

    public static void main(String[] args) {
        VisualLottoGame lottoGame = new VisualLottoGame();
        lottoGame.start();
    }

    private VisualLottoGame() {
        this.windowManager = new WindowManager();
        lottos = new ArrayList<>();
    }

    public void start() {
        windowManager.setMoneyPanel(e -> getMoney());
    }

    public void getMoney() {
        nTotalLotto = windowManager.getInputHandler().getMoney() / 1000;
        windowManager.setAmountOfManualLottoPanel(
                nTotalLotto, e -> getAmountOfManualLotto()
        );
    }

    public void getAmountOfManualLotto() {
        nManualLotto = windowManager.getInputHandler().getManualLottoAmount(nTotalLotto);
        windowManager.setOneManualLottoPanel(nManualLotto, e -> buyOneManualLotto());
        if (nManualLotto == 0) {
            buyAutoLottos();
            windowManager.setPurchasedLottoPanel(lottos, e -> showGeneratedLotto());
        }
    }

    public void buyAutoLottos() {
        while (lottos.size() < nTotalLotto) {
            lottos.add(new Lotto());
        }
    }

    public void buyOneManualLotto() {
        List<Integer> lottoNum = windowManager.getInputHandler().getSixLottoNumber();
        lottos.add(new Lotto(lottoNum));
        if (lottos.size() < nManualLotto) {
            windowManager.setOneManualLottoPanel(nManualLotto - lottos.size(), e -> buyOneManualLotto());
            return;
        }
        buyAutoLottos();
        windowManager.setPurchasedLottoPanel(lottos, e -> showGeneratedLotto());
    }


    public void showGeneratedLotto() {
        windowManager.setWinLottoPanel(e -> getWiningLotto());
    }

    public void getWiningLotto() {
        List<Integer> winningNums = windowManager.getInputHandler().getSixLottoNumber();
        int bonus = windowManager.getInputHandler().getBonusNumber(winningNums);

        winLotto = new WinLotto(winningNums, bonus);

        LottoStat lottoStat = new LottoStat(lottos, winLotto);
        String result = lottoStat.getResult();

        windowManager.setResultLottoPanel(result, e -> haltAll());
    }

    public void haltAll() {
        System.exit(0);
    }

}
