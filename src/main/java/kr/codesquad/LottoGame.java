package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private List<Lotto> lottos;
    private LottoStat lottoStat;

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
        List<Integer> winningNumbers = UserInputHandler.getSixNumber();
        bonusNo = UserInputHandler.getBonusNumber(winningNumbers);
        winning = new Lotto(winningNumbers);
    }


    protected void buyLottos(){
        int n_lotto = UserInputHandler.getMoney() / 1000;
        int n_left_lotto = n_lotto - buyManualLotto(n_lotto, lottos);
        buyAutoLotto(n_left_lotto, lottos);
    }

    protected void buyAutoLotto(int n_lotto, List<Lotto> lottos){
        for(int i =0; i<n_lotto; i++){
            lottos.add(new Lotto());
        }
        System.out.println(String.format("%d개를 구매했습니다.", lottos.size()));
    }

    protected int buyManualLotto(int max_lotto, List<Lotto> lottos){
        List<Lotto> lottoList = UserInputHandler.buyManualLotto(max_lotto);
        lottos.addAll(lottoList);
        return lottoList.size();
    }
}
