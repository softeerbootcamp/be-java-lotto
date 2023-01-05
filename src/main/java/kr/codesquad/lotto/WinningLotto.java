package kr.codesquad.lotto;

import kr.codesquad.Rank;

import java.util.List;
import java.util.Map;

public class WinningLotto {
    private final List<LottoNumber> lottoNumbers;
    private final int bonus;

    private WinningLotto(List<LottoNumber> lottoNumbers, int bonus) {
        this.lottoNumbers = lottoNumbers;
        this.bonus = bonus;
    }

    public static WinningLotto of(List<LottoNumber> lottoNumbers, int bonus) {
        return new WinningLotto(lottoNumbers, bonus);
    }

    public Map<Rank, Integer> getLottoResult(List<Lotto> lottos) {
        Map<Rank, Integer> result = Rank.initMap();
        for(Lotto lotto : lottos) {
            Rank rank = getRank(lotto);
            if(rank != Rank.MISS) {
                result.put(rank, result.get(rank)+1);
            }
        }
        return result;
    }

    private Rank getRank(Lotto lotto) {
        for(Rank rank : Rank.values()) {
            int matchCount = getMatchingCount(lotto);
            boolean isBonusContained = isBonusContained(lotto);
            if(matchCount == Rank.SECOND.getCountOfMatch()) {
                return isBonusContained ? Rank.SECOND : Rank.THIRD;
            }
            if(matchCount == rank.getCountOfMatch()) {
                return rank;
            }
        }
        return Rank.MISS;
    }

    private int getMatchingCount(Lotto lotto) {
        int count = 0;
        for(LottoNumber lottoNumber : lottoNumbers) {
            count += lotto.contains(lottoNumber);
        }

        return count;
    }

    private boolean isBonusContained(Lotto lotto) {
        return lotto.containsBonus(bonus);
    }
}
