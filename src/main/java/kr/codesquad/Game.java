package kr.codesquad;

import java.util.*;

public class Game {
    public static int PRICE = 1000;
    public static int NUM_COUNT = 6;
    private static int RANGE = 45;
    private List<Integer> numberList;
    private List<Lotto> boughtLottoList;
    private int[] matches = new int[4];
    private Lotto jackpotLotto;

    private int outcome;
    public Game()
    {
        numberList = new ArrayList<>();
        for(int i=0;i<RANGE;i++)
        {
            numberList.add(i+1);
        }
        boughtLottoList = new ArrayList<>();
        jackpotLotto = new Lotto();
        Arrays.fill(matches,0);
        outcome = 0;
    }
    public void start()
    {
        getOutcome();
        makeBoughtList();
        makeJackpotLotto();
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
    private void getMatchCounts()
    {
        for (Lotto lotto : boughtLottoList) {
            isContaining(lotto);
        }
    }
    private void isContaining(Lotto lotto)
    {
        int count = 0;
        for(Integer elem : lotto.getLottoList())
        {
            count += jackpotLotto.getLottoList().contains(elem) ? 1 : 0;
        }
        if(count >= 3)
        {
            matches[count-3] += 1;
        }
    }
    private void getStatistic()
    {
        System.out.println("당첨 통계");
        System.out.println("------------");
        Rank[] ranks = Rank.values();
        for(Rank rank : ranks)
        {
            System.out.println(rank.getCountOfMatch() + "개 일치 " + "(" + rank.getWinningMoney() + "원) - " + matches[rank.getCountOfMatch()-3] + "개");
        }
    }

    private void getProfit()
    {
        double income = 0;
        for(Rank rank : Rank.values())
        {
            income += matches[rank.getCountOfMatch()-3] * rank.getWinningMoney();
        }
        System.out.println("수익률은 " + String.format("%.2f",((income - outcome)/outcome)*100) + "%입니다");
    }
}
