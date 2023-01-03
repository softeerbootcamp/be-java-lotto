package kr.codesquad;

import java.util.*;
import static java.util.Objects.isNull;

public class LottoSystem {
    private int money;
    private long earnMoney;
    private double rate;
    private List<Integer> winNums;
    private int bonus;
    List<Lotto> lottos = new ArrayList<>();
    public static final int COST = 1000;
    private Map<Rank, Integer> result = new LinkedHashMap<>(){
        {
            put(Rank.FIFTH, 0);
            put(Rank.FOURTH, 0);
            put(Rank.THIRD, 0);
            put(Rank.SECOND, 0);
            put(Rank.FIRST, 0);
        }
    };

    public void getLottos() {
        money = LottoInput.enterMoney();
        for (int i = 0; i < money / COST; i++) {
            Lotto l = new Lotto();
            lottos.add(l);
        }
        winNums = LottoInput.enterWin();
        bonus = LottoInput.enterBonus();
        LottoOutput.printLottos(lottos);
    }

    public void calWinner(Rank rank){
        if(!isNull(rank)) result.put(rank, result.get(rank)+1);
    }
    public void getResult(){
        for (int i = 0; i < money / COST; i++) {
            int cnt = lottos.get(i).checkWin(winNums);
            boolean boolBonus = lottos.get(i).checkBonus(bonus);
            Rank rank = Rank.valueOf(cnt, boolBonus);
            calWinner(rank);
        }
        calMoneyAndRate();
        LottoOutput.printResult(result, rate);
    }
    public void calMoneyAndRate(){
        earnMoney = 0;
        result.forEach((r, c) -> earnMoney += r.getPrize() * (long)c);
        rate = (earnMoney - money) / (double) money * 100;
    }
}