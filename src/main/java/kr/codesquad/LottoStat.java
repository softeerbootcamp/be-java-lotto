package kr.codesquad;

import java.util.List;

public class LottoStat {

    private long total_money;
    private int[] winnings = {0,0,0,0,0,0,0};
    private List<Lotto> lottos;
    private List<Integer> winningNums;
    public LottoStat(List<Lotto> lottos, List<Integer> winningNums){
        this.lottos = lottos;
        this.winningNums = winningNums;
        System.out.println(winningNums);

        calcResult();
    }

    public void calcResult() {
        for(int i =0; i<winnings.length; i++){
            winnings[i] = 0;
        }
        for(Lotto lotto : lottos){
            int count = lotto.getRightCount(winningNums);
            winnings[count] ++;
            total_money += Lotto.getMoneyByCount(count);
        }
    }

    public void printResult(){
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(String.format("3개 일치 (5000원)- %d개", winnings[3]));
        System.out.println(String.format("4개 일치 (50000원)- %d개", winnings[4]));
        System.out.println(String.format("5개 일치 (15000원)- %d개", winnings[5]));
        System.out.println(String.format("6개 일치 (2000000원)- %d개", winnings[6]));
        double roi = (double)(total_money - lottos.size() * 1000) / (lottos.size() * 1000) * 100;
        System.out.println(String.format("총 수익률은 %.2f%입니다.", roi));
    }

}
