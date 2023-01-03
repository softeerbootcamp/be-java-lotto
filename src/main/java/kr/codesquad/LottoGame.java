package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

import static kr.codesquad.UserInputHandler.getOneNumber;
import static kr.codesquad.UserInputHandler.getSixNumber;

public class LottoGame {
    private List<Lotto> lottos;
    private LottoStat lottoStat;

    private int nManualLotto;
    private int nAutoLotto;
    private Lotto winning;
    private int bonusNo;
    public LottoGame(){
        lottos = new ArrayList<>();
    }
    public void start(){
        buyLottos();
        getWinning();
        printResult();
    }

    protected void printResult(){
        lottoStat = new LottoStat(lottos, winning, bonusNo);
        lottoStat.printResult();
    }

    protected void getWinning(){
        List<Integer> winningNumbers = getSixNumber();
        bonusNo = UserInputHandler.getBonusNumber(winningNumbers);
        winning = new Lotto(winningNumbers);
    }


    protected void buyLottos(){
        int nTotalLotto = UserInputHandler.getMoney() / 1000;
        nManualLotto = buyManualLotto(nTotalLotto, lottos);
        nAutoLotto = nTotalLotto - nManualLotto;
        buyAutoLotto(nAutoLotto, lottos);
        System.out.println(String.format("수동으로 %d장 자동으로 %d개를 구매했습니다.", nManualLotto, nAutoLotto));
        printLottos();
    }

    protected void buyAutoLotto(int n_lotto, List<Lotto> lottos){
        for(int i =0; i<n_lotto; i++){
            lottos.add(new Lotto());
        }
    }

    protected int buyManualLotto(int max_lotto, List<Lotto> lottos){
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int n_lotto = getOneNumber(0, max_lotto);
        List<Lotto> manualLotto = new ArrayList<>();
        for(int i =0; i<n_lotto; i++){
            List<Integer> sixNumber = getSixNumber();
            manualLotto.add(new Lotto(sixNumber));
        }
        lottos.addAll(manualLotto);
        return manualLotto.size();
    }

    protected void printLottos(){
        for(Lotto lotto : lottos){
            System.out.println(lotto);
        }
    }

}
