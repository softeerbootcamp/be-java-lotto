package kr.codesquad;

import kr.codesquad.InputManager.UserInputHandler;
import kr.codesquad.InputManager.UserInputHandlerImpl;
import kr.codesquad.Lotto.Lotto;
import kr.codesquad.Lotto.LottoStat;
import kr.codesquad.Lotto.WinLotto;

import java.util.ArrayList;
import java.util.List;


public class MainLottoGame {
    private List<Lotto> lottos;
    private LottoStat lottoStat;
    private int nManualLotto;
    private int nAutoLotto;
    private WinLotto winLotto;
    private UserInputHandler inputHandler;

    public MainLottoGame() {
        lottos = new ArrayList<>();
        inputHandler = new UserInputHandlerImpl();
    }

    public void start() {
        buyLottos();
        getWinning();
        printResult();
    }

    protected void printResult() {
        lottoStat = new LottoStat(lottos, winLotto);
        lottoStat.printResult();
    }

    protected void getWinning() {
        List<Integer> winningNumbers = inputHandler.getSixLottoNumber();
        int bonusNo = inputHandler.getBonusNumber(winningNumbers);
        winLotto = new WinLotto(winningNumbers, bonusNo);
    }

    protected void buyLottos() {
        int nTotalLotto = inputHandler.getMoney() / 1000;
        nManualLotto = buyManualLotto(nTotalLotto);
        nAutoLotto = nTotalLotto - nManualLotto;
        buyAutoLotto(nAutoLotto);
        System.out.println(String.format("수동으로 %d장 자동으로 %d개를 구매했습니다.", nManualLotto, nAutoLotto));
        printLottos();
    }

    protected void buyAutoLotto(int n_lotto) {
        for (int i = 0; i < n_lotto; i++) {
            lottos.add(new Lotto());
        }
    }

    protected int buyManualLotto(int max_lotto) {
        int nManualLotto = inputHandler.getManualLottoAmount(max_lotto);
        List<Lotto> manualLotto = new ArrayList<>();
        for (int i = 0; i < nManualLotto; i++) {
            List<Integer> sixNumber = inputHandler.getSixLottoNumber();
            manualLotto.add(new Lotto(sixNumber));
        }
        lottos.addAll(manualLotto);
        return manualLotto.size();
    }

    protected void printLottos() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }


    public static void main(String[] args) {
        MainLottoGame mainLottoGame = new MainLottoGame();
        mainLottoGame.start();
    }
}
