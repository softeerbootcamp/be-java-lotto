package kr.codesquad.lotto;

import kr.codesquad.winLotto.WinCount;
import kr.codesquad.winLotto.WinLotto;

import java.util.*;

public class LottoService {

    public static final int LOTTO_NUM_MIN_BOUND = 1;
    public static final int LOTTO_NUM_MAX_BOUND = 45;
    public static final int LOTTO_NUM_COUNT = 6;
    public static final Map<WinCount, Integer> lottoResult = new HashMap<>();

    public Map<WinCount, Integer> getLottoResult() {
        return lottoResult;
    }


    public Map<WinCount, Integer> makeLottoResult(List<Lotto> lottoList, WinLotto winLotto) {
        for (Lotto lotto : lottoList) {
            makeLottoResultCount(lotto, winLotto);
        }
        return getLottoResult();
    }

    private static WinCount findWinningCount(int correctCnt, boolean isBonusInclude) {
        WinCount winCount = Arrays.stream(WinCount.values())
                .filter(count -> (count.getCount() == correctCnt && count.getIsBonus() == isBonusInclude))
                .findFirst()
                .orElse(null);
        return winCount;
    }

    private static void addWinningCount(WinCount winCount) {
        if (lottoResult.containsKey(winCount)) {
            lottoResult.put(winCount, lottoResult.get(winCount) + 1);
        }
        if (!lottoResult.containsKey(winCount)) {
            lottoResult.put(winCount, 1);
        }

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
        return correctCnt == LOTTO_NUM_COUNT - 1 && lottoNumbers.getNumberList().contains(winLotto.getBonusNum());
    }

}
