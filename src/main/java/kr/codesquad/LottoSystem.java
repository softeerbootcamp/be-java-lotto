package kr.codesquad;

import java.util.*;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

public class LottoSystem {
    private int money;
    private long earnMoney;
    private double rate;
    private List<Integer> winNums;
    private int bonus;
    Scanner sc;
    List<Lotto> lottos = new ArrayList<>();
    private static final int COST = 1000;
    private Map<Rank, Integer> result = new LinkedHashMap<>();

    public void getMoney() {
        System.out.println("구입금액을 입력해주세요.");
        sc = new Scanner(System.in);
        money = Integer.parseInt(sc.nextLine());
        System.out.println(money / COST + "개를 구매했습니다.");
    }
    public void getLottos() {
        for (int i = 0; i < money / COST; i++) {
            Lotto l = new Lotto();
            lottos.add(l);
            l.printLotto();
        }
    }
    public void getWin() {
        sc = new Scanner(System.in);
        System.out.println("\n당첨 번호를 입력해주세요.");
        List<String> s = Arrays.asList(sc.nextLine().replaceAll(" ", "").split(","));
        winNums = s.stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("보너스 볼을 입력해주세요.");
        bonus = Integer.parseInt(sc.nextLine());
    }
    public void calWinner(Rank rank){
        if(!isNull(rank)) result.put(rank, result.get(rank)+1);
    }
    public void getResult(){
        result.put(Rank.FIFTH, 0);
        result.put(Rank.FOURTH, 0);
        result.put(Rank.THIRD, 0);
        result.put(Rank.SECOND, 0);
        result.put(Rank.FIRST, 0);
        for (int i = 0; i < money / COST; i++) {
            int cnt = lottos.get(i).checkWin(winNums);
            boolean boolBonus = lottos.get(i).checkBonus(bonus);
            Rank rank = Rank.valueOf(cnt, boolBonus);
            calWinner(rank);
        }
        calMoneyAndRate();
    }
    public void calMoneyAndRate(){
        result.forEach((r, c) -> earnMoney += r.getPrize() * (long)c);
        rate = (earnMoney - money) / (double) money * 100;
    }
    public void printResult() {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        result.forEach((r,c)-> System.out.printf("%d개 일치 (%d원)- %d개\n", r.getCnt(), r.getPrize(), c));
        System.out.printf("총 수익률은 %.2f%%입니다.\n", rate);
    }
}