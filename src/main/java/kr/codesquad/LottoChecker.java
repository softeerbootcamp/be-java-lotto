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
}
