package kr.codesquad;

import java.util.*;

public class LottoService {

    public static final int LOTTO_NUM_MIN_BOUND = 1;
    public static final int LOTTO_NUM_MAX_BOUND = 45;
    public static final int LOTTO_NUM_COUNT = 6;
    public static final Map<WinningCount, Integer> lottoResult = new HashMap<>();

    public Map<WinningCount, Integer> getLottoResult() {
        return lottoResult;
    }

    public List<Lotto> makeLottoList(int amount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Lotto lotto = makeRandomLotto();
            lottoList.add(lotto);
        }
        return lottoList;
    }

    public Lotto makeRandomLotto() {
        Lotto lotto = new Lotto();
        lotto.getNumberList().addAll(makeRandomNum());
        return lotto;
    }

    private List<Integer> makeRandomNum() {
        List<Integer> allNumber = new ArrayList<>();
        for (int i = LOTTO_NUM_MIN_BOUND; i <= LOTTO_NUM_MAX_BOUND; i++) {
            allNumber.add(i);
        }
        Collections.shuffle(allNumber);
        List<Integer> randNum = new ArrayList<>();
        randNum.addAll(allNumber.subList(0, LOTTO_NUM_COUNT));
        Collections.sort(randNum);
        return randNum;
    }

    public Map<WinningCount, Integer> makeLottoResult(List<Lotto> lottoList, WinLotto winLotto) {
        for (Lotto lotto : lottoList) {
            makeLottoResultCount(lotto, winLotto);
        }
        return getLottoResult();
    }

    private static WinningCount findWinningCount(int correctCnt, boolean isBonusInclude) {
        WinningCount winningCount = Arrays.stream(WinningCount.values())
                .filter(count -> (count.getCount() == correctCnt && count.getIsBonus() == isBonusInclude))
                .findFirst()
                .orElse(null);
        return winningCount;
    }

    private static void addWinningCount(WinningCount winningCount) {
        if (lottoResult.containsKey(winningCount)) {
            lottoResult.put(winningCount, lottoResult.get(winningCount) + 1);
        }
        if (!lottoResult.containsKey(winningCount)) {
            lottoResult.put(winningCount, 1);
        }

    }

    public void makeLottoResultCount(Lotto lottoNumbers, WinLotto winLotto) {
        int correctCnt = correctNumCnt(lottoNumbers, winLotto);
        boolean isBonusWin = checkBonusWin(lottoNumbers, correctCnt, winLotto);
        WinningCount winningCount = findWinningCount(correctCnt, isBonusWin);
        if (winningCount != null) {
            addWinningCount(winningCount);
        }
    }

    public int correctNumCnt(Lotto lottoNumbers, WinLotto winLotto) {
        List<Integer> temp = new ArrayList<>(lottoNumbers.getNumberList());
        temp.retainAll(winLotto.getWinLotto().getNumberList());
        return temp.size();
    }

    public boolean checkBonusWin(Lotto lottoNumbers, int correctCnt, WinLotto winLotto) {
          if(correctCnt == LOTTO_NUM_COUNT - 1 && lottoNumbers.getNumberList().contains(winLotto.getBonusNum()))  {
              return true;
          }
          return false;
    }


}
