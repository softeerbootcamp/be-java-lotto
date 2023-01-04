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

        for(List<Integer> eachLottoNum : lottoList)
            setResult(result, countWinNum(eachLottoNum, winNumList), checkBonus(eachLottoNum, winNumList.get(6)));

        printResult(result);
    }
}
