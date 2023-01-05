package kr.codesquad;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoChecker {
    private final List<Integer> winNumList;
    private final int bonusNum;
    private final Map<Rank, Integer> result = new EnumMap<>(Rank.class);

    public LottoChecker() {
        UserInput ui = new UserInput();
        this.winNumList = ui.inputWinNum();
        this.bonusNum = ui.inputBonusNum();
        for(Rank rank : Rank.values()) this.result.put(rank, 0);
    }

    public void checkLotto(Lotto lotto) {
        List<List<Integer>> lottoList = lotto.getLottoList();

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
            if(winNumCount == rank.getCountOfMatch() && isBonus == rank.getIsBonus())
                result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }

    public void printResult(Map<Rank, Integer> result, int lottoCount) {
        long resultPrice = 0;

        System.out.println("당첨 통계");
        System.out.println("---------");

        for(Map.Entry<Rank, Integer> resultEntry : result.entrySet()) {
            String resultString = resultEntry.getKey().getIsBonus() ?
                    resultEntry.getKey().getCountOfMatch() + "개 일치, 보너스 볼 일치 (" +
                            resultEntry.getKey().getWinningMoney() + "원)- " + resultEntry.getValue() + "개" :
                    resultEntry.getKey().getCountOfMatch() + "개 일치 (" +
                            resultEntry.getKey().getWinningMoney() + "원)- " + resultEntry.getValue() + "개";

            System.out.println(resultString);
            resultPrice += (long) resultEntry.getValue() * resultEntry.getKey().getWinningMoney();
        }

        long expense = lottoCount * 1000L;
        System.out.printf("총 수익률은 %.2f%%입니다.\n", (float) (resultPrice - expense) / expense * 100);
    }
}