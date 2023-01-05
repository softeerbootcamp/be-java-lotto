package kr.codesquad.domain.lotto;

import kr.codesquad.domain.Rank;
import kr.codesquad.domain.lotto.factory.LottoFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_PRICE = 1000;
    private static final int BONUS_COUNT = 5;

    private final List<LottoNumber> lotto;

    public Lotto(LottoFactory lottoFactory) {
        lotto = new ArrayList<>(lottoFactory.generateLottoNumbers());
    }

    public Lotto(List<Integer> lottoNumbers) {
        this.lotto = lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public boolean contains(LottoNumber number) {
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
        return lotto
                .stream()
                .map(LottoNumber::getLottoNumber).collect(Collectors.toList());
    }

}
