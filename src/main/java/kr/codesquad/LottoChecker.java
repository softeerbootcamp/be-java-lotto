package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class LottoChecker {
    private final List<Integer> result;

    public LottoChecker() {
        this.result = new ArrayList<>(List.of(0, 0, 0, 0, 0));
    }

    public void checkLotto(Lotto lotto, List<Integer> winNumList) {
        List<List<Integer>> lottoList = lotto.getLottoList();

        for(List<Integer> eachLottoList : lottoList)
            setResult(result, countWinNum(eachLottoList, winNumList), checkBonus(eachLottoList, winNumList.get(6)));

        printResult(result);
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
}
