package kr.codesquad;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int n_lotto = UserInputHandler.getMoney() / 1000;
        List<Lotto> lottos = generateLottos(n_lotto);
        List<Integer> winningNumbers = UserInputHandler.getWinningNumbers();
        int bonus = UserInputHandler.getBonusNumber(winningNumbers);
        Lotto winning = new Lotto(winningNumbers);
        LottoStat lottoStat = new LottoStat(lottos, winning, bonus);
        lottoStat.printResult();
    }

    public static List<Lotto> generateLottos(int n_lotto){
        ArrayList<Lotto> lottos = new ArrayList<>();
        for(int i =0; i<n_lotto; i++){
            lottos.add(new Lotto());
        }
        System.out.println(String.format("%d개를 구매했습니다.", lottos.size()));
        return lottos;
    }

}