package kr.codesquad;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kr.codesquad.Prize.*;

public class LottoStat {

    private long total_money;
    private Map<Prize, Integer> winnings;
    private List<Lotto> lottos;
    private List<Integer> winningNums;
    private int winningBonus;

    public LottoStat(List<Lotto> lottos, List<Integer> winningNums, int bonus){
        this.lottos = lottos;
        this.winningNums = winningNums;
        winningBonus = bonus;
        System.out.println(winningNums);
        winnings = new HashMap<>();
        calcResult();
    }

    public void calcResult() {
        for(Prize prize : Prize.values()){
            winnings.put(prize, 0);
        }
        for(Lotto lotto : lottos){
            Prize prize = lotto.getPrize(winningNums, winningBonus);
            winnings.put(prize, winnings.get(prize)+1);
            total_money += prize.getMoney();
        }
    }

    public void printResult(){
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(String.format("3개 일치 (5000원)- %d개", winnings.get(FIFTH)));
        System.out.println(String.format("4개 일치 (50000원)- %d개", winnings.get(FORTH) ));
        System.out.println(String.format("5개 일치 (15000원)- %d개", winnings.get(THIRD) ));
        System.out.println(String.format("5개 일치, 보너스 볼 일치(30000000원) - %d개", winnings.get(SECOND) ));
        System.out.println(String.format("6개 일치 (2000000000)- %d개", winnings.get(FIRST) ));
        double roi = (double)(total_money - lottos.size() * 1000L) / (lottos.size() * 1000) * 100;
        System.out.println(String.format("총 수익률은 %.2f", roi) + "%입니다.");
    }

}
