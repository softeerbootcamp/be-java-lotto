package kr.codesquad.lottoSystem;

import kr.codesquad.UserInput;
import kr.codesquad.lotto.Lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoChecker {
    private final List<Integer> winNumList; // 당첨 번호 저장
    private final int bonusNum; // 보너스 번호 저장
    private final Map<Rank, Integer> result = new EnumMap<>(Rank.class); // 당첨 결과 저장

    public LottoChecker() {
        UserInput ui = new UserInput();
        this.winNumList = ui.inputWinNum();
        this.bonusNum = ui.inputBonusNum();
        for(Rank rank : Rank.values()) this.result.put(rank, 0);
    }

    // 로또의 당첨 결과를 확인하는 기능의 함수
    public void checkLotto(Lotto lotto) {
        List<List<Integer>> lottoList = lotto.getLottoList();

        for(List<Integer> eachLottoList : lottoList)
            setResult(result, countWinNum(eachLottoList), checkBonus(eachLottoList));

        printResult(result, lottoList.size());
    }

    // 하나의 로또에서 몇 개가 맞았는지 확인하는 기능의 함수
    public int countWinNum(List<Integer> eachLottoList) {
        int winNumCount = 0;

        for(int winNum : winNumList)
            winNumCount = eachLottoList.contains(winNum) ? winNumCount + 1 : winNumCount;

        return winNumCount;
    }

    public boolean checkBonus(List<Integer> eachLottoList) {
        return eachLottoList.contains(bonusNum);
    }

    // 당첨 결과 저장하는 기능의 함수
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