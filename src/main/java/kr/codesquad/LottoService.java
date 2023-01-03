package kr.codesquad;

import java.util.*;

public class LottoService {

    public static final int LOTTO_NUM_BOUND = 45;
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
        lotto.numberList.addAll(makeRandomNum());
        return lotto;
    }

    private List<Integer> makeRandomNum() {
        List<Integer> allNumber = new ArrayList<>();
        for (int i = 1; i <= LOTTO_NUM_BOUND; i++) {
            allNumber.add(i);
        }
        Collections.shuffle(allNumber);
        List<Integer> randNum = new ArrayList<>();
        randNum.addAll(allNumber.subList(0, LOTTO_NUM_COUNT));
        Collections.sort(randNum);
        return randNum;
    }

    public Map<WinningCount, Integer> makeLottoResult(List<Lotto> lottoList, Lotto winNum, int bonusNum) {
        for (Lotto lotto : lottoList) {
            makeLottoResultCount(lotto, winNum, bonusNum);
        }
        return getLottoResult();
    }

    public void makeLottoResultCount(Lotto lottoNumbers, Lotto winNum, int bonusNum) {
        int correctCnt = correctNumCnt(lottoNumbers, winNum, bonusNum);
        WinningCount winningCount = findWinningCount(correctCnt, bonusNum);
        if (winningCount != null) {
            addWinningCount(winningCount);
        }
    }

    public int correctNumCnt(Lotto lottoNumbers, Lotto winNum, int bonusNum) {
        List<Integer> temp = lottoNumbers.getNumberList();
        temp.retainAll(winNum.getNumberList());
        return temp.size();
    }

    private static WinningCount findWinningCount(int correctCnt, int bonusNum) {
        WinningCount winningCount = Arrays.stream(WinningCount.values())
                .filter(count -> count.getCount() == correctCnt)
                .findFirst()
                .orElse(null);
        return winningCount;
    }

    private static void addWinningCount(WinningCount winningCount) {
        if(lottoResult.containsKey(winningCount)) {
            lottoResult.put(winningCount, lottoResult.get(winningCount) + 1);
        }
        if(!lottoResult.containsKey(winningCount)) {
            lottoResult.put(winningCount, 1);
        }

    }


}
