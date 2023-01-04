package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class LottoChecker {
    private final List<Integer> result;

    public LottoChecker() {
        this.result = new ArrayList<>(List.of(0, 0, 0, 0, 0));
    }

    public void checkLotto(Lotto lotto, List<Integer> winNumList) {
        for(int i = 0; i < lotto.getLottoList().size(); i++)
            setResult(result, countWinNum(lotto, winNumList, i), checkBonus(lotto, winNumList.get(6), i));

        printResult(result);
    }
}
