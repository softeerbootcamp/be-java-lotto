package kr.codesquad;

import java.util.*;

public class Game {
    public static int PRICE = 1000;
    public static int NUM_COUNT = 6;
    private static int RANGE = 45;
    private List<Integer> numberList;
    private List<Lotto> boughtLottoList;
    private Map<Rank, Integer> matchCountFrequency;
    private Lotto jackpotLotto;
    private int bonus;
    private int outcome;

    public Game()
    {
        numberList = new ArrayList<>();
        for(int i=0;i<RANGE;i++) {
            numberList.add(i+1);
        }
        bonus = 0;
        boughtLottoList = new ArrayList<>();
        jackpotLotto = new Lotto();
        matchCountFrequency = Rank.initMap();
        outcome = 0;
    }

    public void start()
    {
        getOutcome();
        makeBoughtList();
        makeJackpotLotto();
        setBonus();
        getMatchCounts();
        getStatistic();
        getProfit();
    }

    private void getOutcome()
    {
        System.out.println("구입 금액을 입력해주세요");
        Scanner scanner = new Scanner(System.in);
        outcome = scanner.nextInt();
        System.out.println(outcome/PRICE + "개를 구매했습니다");
    }

    private void makeBoughtList()
    {
        for(int i=0;i<outcome/PRICE;i++)
        {
            Collections.shuffle(numberList);
            Lotto lotto = new Lotto(numberList.subList(0, NUM_COUNT));
            System.out.println(lotto.getLottoList());
            boughtLottoList.add(lotto);
        }
    }

    private void makeJackpotLotto()
    {
        System.out.println("당첨 번호를 입력해주세요");
        Scanner scanner = new Scanner(System.in);
        String numberString = scanner.nextLine();
        StringTokenizer stringTokenizer = new StringTokenizer(numberString, ", ");
        while(stringTokenizer.hasMoreTokens())
        {
            jackpotLotto.getLottoList().add(Integer.parseInt(stringTokenizer.nextToken()));
        }
    }

    private void setBonus()
    {
        System.out.println("보너스 볼을 입력하세요");
        Scanner scanner = new Scanner(System.in);
        bonus = scanner.nextInt();
    }

    private void getMatchCounts()
    {
        for (Lotto lotto : boughtLottoList) {
            isContaining(lotto);
        }
    }

    private void isContaining(Lotto lotto)
    {
        int count = 0;
        for(Integer elem : lotto.getLottoList()) {
            count += jackpotLotto.getLottoList().contains(elem) ? 1 : 0;
        }
        if(lotto.getLottoList().contains(bonus)) {
            lotto.setMatchesBonus(true);
        }
        if(count >= 3) {
            lotto.setMatchCount(count);
        }
    }

    private Rank getRank(Lotto lotto)
    {
        for(Rank rank : Rank.values())
        {
            if(lotto.getMatchCount() == Rank.SECOND.getCountOfMatch()) return lotto.getMatchesBonus() ? Rank.SECOND : Rank.THIRD;
            if(lotto.getMatchCount() == rank.getCountOfMatch()) return rank;
        }
        return null;
    }

    private void getMatchFrequency()
    {
        for(Lotto lotto : boughtLottoList)
        {
            Rank rk = getRank(lotto);
            if(rk != null) matchCountFrequency.replace(rk, matchCountFrequency.get(rk), matchCountFrequency.get(rk)+1);
        }
    }

    private String getPrintString(Rank rank)
    {
        String printString = rank.getCountOfMatch() + "개 일치 " + "(" + rank.getWinningMoney() + "원) - " + matchCountFrequency.get(rank) + "개";
        if(rank.getCountOfMatch() == Rank.SECOND.getCountOfMatch())
        {
             printString = rank.getCountOfMatch() + "개 일치, 보너스 볼 일치" + "(" + Rank.SECOND.getWinningMoney() + "원) - " + matchCountFrequency.get(rank) + "개";
        }
        return printString;
    }

    private void getStatistic()
    {
        getMatchFrequency();
        System.out.println("당첨 통계");
        System.out.println("------------");
        for(Rank rank : Rank.values())
        {
            System.out.println(getPrintString(rank));
        }
    }

    private void getProfit()
    {
        double income = 0;
        for(Rank rank : Rank.values())
        {
            income += matchCountFrequency.get(rank) * rank.getWinningMoney();
        }
        System.out.println("수익률은 " + String.format("%.2f",((income - outcome)/outcome)*100) + "%입니다");
    }
}
