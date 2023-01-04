package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class LottoChecker {
    private final List<Integer> winNumList;
    private final int bonusNum;
    private final List<Integer> result;

    public LottoChecker() {
        UserInput ui = new UserInput();
        this.winNumList = ui.inputWinNum();
        this.bonusNum = ui.inputBonusNum();
        this.result = new ArrayList<>(List.of(0, 0, 0, 0, 0));
    }

    public void checkLotto(Lotto lotto) {
        List<List<Integer>> lottoList = lotto.getLottoList();

        for(List<Integer> eachLottoList : lottoList)
            setResult(result, countWinNum(eachLottoList), checkBonus(eachLottoList));

        printResult(result, lottoList.size());
    }

    public int countWinNum(List<Integer> eachLottoList, List<Integer> winNumList) {
        int winNumCount = 0;

        if(eachLottoList.contains(winNumList.get(0))) winNumCount++;
        if(eachLottoList.contains(winNumList.get(1))) winNumCount++;
        if(eachLottoList.contains(winNumList.get(2))) winNumCount++;
        if(eachLottoList.contains(winNumList.get(3))) winNumCount++;
        if(eachLottoList.contains(winNumList.get(4))) winNumCount++;
        if(eachLottoList.contains(winNumList.get(5))) winNumCount++;

        return winNumCount;
    }

    public boolean checkBonus(List<Integer> eachLottoList, int bonusNum) {
        return eachLottoList.contains(bonusNum);
    }

    public void setResult(List<Integer> result, int winNumCount, boolean isBonus) {
        if(winNumCount == Rank.FIFTH.getCountOfMatch()) result.set(0, result.get(0) + 1);
        else if(winNumCount == Rank.FOURTH.getCountOfMatch()) result.set(1, result.get(1) + 1);
        else if(winNumCount == Rank.SECOND.getCountOfMatch() && isBonus) result.set(3, result.get(3) + 1);
        else if(winNumCount == Rank.THIRD.getCountOfMatch()) result.set(2, result.get(2) + 1);
        else if(winNumCount == Rank.FIRST.getCountOfMatch()) result.set(4, result.get(4) + 1);
    }

    public void printResult(List<Integer> result, int lottoCount) {
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
