package kr.codesquad;

import kr.codesquad.InputManager.AwtInputHandler;
import kr.codesquad.InputManager.UserInputHandler;
import kr.codesquad.Lotto.Lotto;
import kr.codesquad.Lotto.LottoStat;
import kr.codesquad.Lotto.WinLotto;
import kr.codesquad.UI.WindowManager;

import java.util.ArrayList;
import java.util.List;


public class VisualLottoGame {
    private static VisualLottoGame lottoGame;
    WindowManager windowManager;
    private final List<Lotto> lottos;
    private WinLotto winLotto;
    private int nTotalLotto;
    private int nManualLotto;

    public static void main(String[] args) {
        getVisualLottoGame().start();
    }

    private VisualLottoGame() {
        this.windowManager = new WindowManager();
        lottos = new ArrayList<>();
    }

    public static VisualLottoGame getVisualLottoGame() {
        if(lottoGame == null)
            lottoGame = new VisualLottoGame();
        return lottoGame;
    }

    public void start() {
        windowManager.setMoneyPanel();
    }

    public void getMoney() {
        nTotalLotto = windowManager.getInputHandler().getMoney();
        windowManager.setAmountOfManualLottoPanel(nTotalLotto);
    }

    public void getAmountOfManualLotto() {
        nManualLotto = windowManager.getInputHandler().getManualLottoAmount(nTotalLotto);
        windowManager.setOneManualLottoPanel(nManualLotto);
    }

    public void buyOneManualLotto() {
        List<Integer> lottoNum = windowManager.getInputHandler().getSixLottoNumber();
        lottos.add(new Lotto(lottoNum));
        if (lottos.size() != nManualLotto) {
            windowManager.setOneManualLottoPanel(nManualLotto - lottos.size());
            return;
        }
        while(lottos.size() < nTotalLotto){
            lottos.add(new Lotto());
        }
        windowManager.setPurchasedLottoPanel(lottos);
    }

    public void showGeneratedLotto() {
        windowManager.setWinLottoPanel();
    }

    public void getWiningLotto() {
        List<Integer> winningNums = windowManager.getInputHandler().getSixLottoNumber();
        int bonus = windowManager.getInputHandler().getBonusNumber(winningNums);
        winLotto = new WinLotto(winningNums, bonus);
        LottoStat lottoStat = new LottoStat(lottos, winLotto);
        String result = lottoStat.getResult();
        windowManager.setResultLottoPanel(result);
    }

    public void haltAll(){
        System.exit(0);
    }

}
