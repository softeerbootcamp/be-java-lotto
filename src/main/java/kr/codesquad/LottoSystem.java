package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LottoSystem {
    private final List<Integer> numList;
    private final Scanner sc;

    private static int lottoCount;

    public LottoSystem() {
        this.numList = new ArrayList<>();
        for(int i = 1;i <= 45;i++) this.numList.add(i);
        sc = new Scanner(System.in);
    }

    public Lotto buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        lottoCount = sc.nextInt() / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");

        return new Lotto(shuffle(lottoCount));
    }

    public List<List<Integer>> shuffle(int lottoCount) {
        List<List<Integer>> lottoList = new ArrayList<>();

        for(int i = 0;i < lottoCount;i++) {
            Collections.shuffle(numList);
            List<Integer> subList = new ArrayList<>(numList.subList(0, 6));

            lottoList.add(subList);
            Collections.sort(lottoList.get(i));
            System.out.println(lottoList.get(i));
        }

        return lottoList;
    }

    public void checkLotto(Lotto lotto) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] winNum = sc.nextLine().split(", ");

        List<Integer> winNumList = new ArrayList<>();
        for(int i = 0;i < 6;i++) winNumList.add(Integer.parseInt(winNum[i]));

        System.out.println("보너스 볼을 입력해 주세요.");
        winNumList.add(sc.nextInt());

        List<Integer> result = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        for(int i = 0; i < lottoCount; i++)
            setResult(result, countWinNum(lotto, winNumList, i), checkBonus(lotto, winNumList.get(6), i));

        printResult(result);
    }

    public int countWinNum(Lotto lotto, List<Integer> winNumList, int index) {
        List<List<Integer>> lottoList = lotto.getLottoList();
        int winNumCount = 0;

        if(lottoList.get(index).contains(winNumList.get(0))) winNumCount++;
        if(lottoList.get(index).contains(winNumList.get(1))) winNumCount++;
        if(lottoList.get(index).contains(winNumList.get(2))) winNumCount++;
        if(lottoList.get(index).contains(winNumList.get(3))) winNumCount++;
        if(lottoList.get(index).contains(winNumList.get(4))) winNumCount++;
        if(lottoList.get(index).contains(winNumList.get(5))) winNumCount++;

        return winNumCount;
    }

    public boolean checkBonus(Lotto lotto, int bonusNum, int index) {
        List<List<Integer>> lottoList = lotto.getLottoList();

        return lottoList.get(index).contains(bonusNum);
    }

    public void setResult(List<Integer> result, int winNumCount, boolean isBonus) {
        if(winNumCount == Rank.FIFTH.getCountOfMatch()) result.set(0, result.get(0) + 1);
        else if(winNumCount == Rank.FOURTH.getCountOfMatch()) result.set(1, result.get(1) + 1);
        else if(winNumCount == Rank.SECOND.getCountOfMatch() && isBonus) result.set(3, result.get(3) + 1);
        else if(winNumCount == Rank.THIRD.getCountOfMatch()) result.set(2, result.get(2) + 1);
        else if(winNumCount == Rank.FIRST.getCountOfMatch()) result.set(4, result.get(4) + 1);
    }

    public void printResult(List<Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println("3개 일치 (5000원)- " + result.get(0) + "개");
        System.out.println("4개 일치 (50000원)- " + result.get(1) + "개");
        System.out.println("5개 일치 (1500000원)- " + result.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30000000원)- " + result.get(3) + "개");
        System.out.println("6개 일치 (2000000000원)- " + result.get(4) + "개");

        long resultPrice = (long) result.get(0) * Rank.FIFTH.getWinningMoney() +
                (long) result.get(1) * Rank.FOURTH.getWinningMoney() +
                (long) result.get(2) * Rank.THIRD.getWinningMoney() +
                (long) result.get(3) * Rank.SECOND.getWinningMoney() +
                (long) result.get(4) * Rank.FIRST.getWinningMoney();
        long expense = lottoCount * 1000L;
        System.out.printf("총 수익률은 %.2f%%입니다.\n", (float) (resultPrice - expense) / expense * 100);
    }
}
