package kr.codesquad.winLotto;

import kr.codesquad.lotto.Lotto;
import kr.codesquad.lotto.Lottos;

import java.util.*;

public class WinResult {

    public static final int BONUS_WIN_NUM_COUNT = 5;
    public static final Map<WinCount, Integer> winResult = new HashMap<>();

    private static WinCount findWinningCount(int correctCnt, boolean isBonusInclude) {
        return Arrays.stream(WinCount.values())
                .filter(count -> (count.getCount() == correctCnt))
                .filter(count -> (count.getIsBonus() == isBonusInclude))
                .findFirst().orElse(null);
    }

    private static void addWinningCount(WinCount winCount) {
        if (winResult.containsKey(winCount)) {
            winResult.put(winCount, winResult.get(winCount) + 1);
        }
        if (!winResult.containsKey(winCount)) {
            winResult.put(winCount, 1);
        }

    }

    public Map<WinCount, Integer> makeLottoResult(Lottos lottos, WinLotto winLotto) {
        for (Lotto lotto : lottos.getLottos()) {
            makeLottoResultCount(lotto, winLotto);
        }
        return winResult;
    }

    public void makeLottoResultCount(Lotto lotto, WinLotto winLotto) {
        int correctCnt = lotto.countCorrectNum(winLotto);
        boolean isBonusWin = checkBonusWin(lotto, correctCnt, winLotto);
        WinCount winCount = findWinningCount(correctCnt, isBonusWin);
        if (winCount != null) {
            addWinningCount(winCount);
        }
    }

    public boolean checkBonusWin(Lotto lotto, int correctCnt, WinLotto winLotto) {
        return correctCnt == BONUS_WIN_NUM_COUNT && lotto.isContainBonusNum(winLotto.getBonusNum());
    }
}
