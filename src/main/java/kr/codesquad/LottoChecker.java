package kr.codesquad;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoChecker {
    private final List<Integer> winNumList;
    private final int bonusNum;

    public LottoChecker() {
        UserInput ui = new UserInput();
        this.winNumList = ui.inputWinNum();
        this.bonusNum = ui.inputBonusNum();
    }

    public void checkLotto(Lotto lotto) {
        List<List<Integer>> lottoList = lotto.getLottoList();
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);

        for(List<Integer> eachLottoList : lottoList)
            setResult(result, countWinNum(eachLottoList), checkBonus(eachLottoList));

        printResult(result, lottoList.size());
    }

    public int countWinNum(List<Integer> eachLottoList) {
        int winNumCount = 0;

        for(int winNum : winNumList)
            winNumCount = eachLottoList.contains(winNum) ? winNumCount + 1 : winNumCount;

        return winNumCount;
    }

    public boolean checkBonus(List<Integer> eachLottoList) {
        return eachLottoList.contains(bonusNum);
    }

    public void setResult(Map<Rank, Integer> result, int winNumCount, boolean isBonus) {
        for(Rank rank : result.keySet()) {
            if(winNumCount == rank.getCountOfMatch() && !rank.getIsBonus())
                result.put(rank, result.getOrDefault(rank, 0) + 1);
            else
                result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
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
