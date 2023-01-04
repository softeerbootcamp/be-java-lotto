package kr.codesquad.winLotto;

import kr.codesquad.lotto.Lotto;

import java.util.*;

public class WinResult {

    public static final int BONUS_WIN_NUM_COUNT = 5;
    public static final Map<WinCount, Integer> winResult = new HashMap<>();

    private static WinCount findWinningCount(int correctCnt, boolean isBonusInclude) {
        WinCount winCount = Arrays.stream(WinCount.values()).filter(count -> (count.getCount() == correctCnt && count.getIsBonus() == isBonusInclude)).findFirst().orElse(null);
        return winCount;
    }

    private static void addWinningCount(WinCount winCount) {
        if (winResult.containsKey(winCount)) {
            winResult.put(winCount, winResult.get(winCount) + 1);
        }
        if (!winResult.containsKey(winCount)) {
            winResult.put(winCount, 1);
        }

    }

    public Map<WinCount, Integer> makeLottoResult(List<Lotto> lottoList, WinLotto winLotto) {
        for (Lotto lotto : lottoList) {
            makeLottoResultCount(lotto, winLotto);
        }
        return winResult;
    }

    public void makeLottoResultCount(Lotto lottoNumbers, WinLotto winLotto) {
        int correctCnt = correctNumCnt(lottoNumbers, winLotto);
        boolean isBonusWin = checkBonusWin(lottoNumbers, correctCnt, winLotto);
        WinCount winCount = findWinningCount(correctCnt, isBonusWin);
        if (winCount != null) {
            addWinningCount(winCount);
        }
    }

    public int correctNumCnt(Lotto lottoNumbers, WinLotto winLotto) {
        List<Integer> temp = new ArrayList<>(lottoNumbers.getNumberList());
        temp.retainAll(winLotto.getWinLotto().getNumberList());
        return temp.size();
    }

    public boolean checkBonusWin(Lotto lottoNumbers, int correctCnt, WinLotto winLotto) {
        return correctCnt == BONUS_WIN_NUM_COUNT && lottoNumbers.getNumberList().contains(winLotto.getBonusNum());
    }
}
