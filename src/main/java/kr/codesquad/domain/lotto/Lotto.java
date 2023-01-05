package kr.codesquad.domain.lotto;

import kr.codesquad.domain.Rank;
import kr.codesquad.domain.lotto.factory.LottoFactory;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int BONUS_COUNT = 5;

    private final List<Integer> lotto;

    public Lotto(LottoFactory lottoFactory) {
        lotto = new ArrayList<>(lottoFactory.generateLottoNumbers());
    }

    public Lotto(List<Integer> lottoNumbers) {
        this.lotto = new ArrayList<>(new ArrayList<>(lottoNumbers));
    }

    public boolean contains(int number) {
        return lotto.contains(number);
    }

    public Rank getRank(WinLotto winLotto) {
        int matchCount = getMatchCount(winLotto.getWinLotto());
        if (matchCount == BONUS_COUNT && lotto.contains(winLotto.getBonusBall())) {
            return Rank.getRank(matchCount, true);
        }
        return Rank.getRank(matchCount, false);
    }

    private int getMatchCount(Lotto targetLotto) {
        return (int) lotto.stream()
                .filter(targetLotto::contains)
                .count();
    }

    public List<Integer> getLotto() {
        return new ArrayList<>(new ArrayList<>(lotto));
    }

}
