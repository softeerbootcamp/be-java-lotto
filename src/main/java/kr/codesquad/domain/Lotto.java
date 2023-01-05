package kr.codesquad.domain;

import kr.codesquad.factory.LottoFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
