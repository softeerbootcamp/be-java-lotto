package kr.codesquad.lotto;

import kr.codesquad.Rank;
import kr.codesquad.exception.DuplicateLottoNumberException;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class WinningLotto {
    private final List<LottoNumber> lottoNumbers;

    private final LottoNumber bonus;

    private WinningLotto(List<LottoNumber> lottoNumbers, LottoNumber bonus) {
        if(!verify(lottoNumbers, bonus)) {
            throw new DuplicateLottoNumberException();
        }
        this.lottoNumbers = lottoNumbers;
        this.bonus = bonus;
    }

    public static WinningLotto of(List<LottoNumber> lottoNumbers, LottoNumber bonus) {
        return new WinningLotto(lottoNumbers, bonus);
    }

    private boolean verify(List<LottoNumber> list, LottoNumber bonus) {
        for(LottoNumber lottoNumber : list) {
            if (list.contains(bonus) || Collections.frequency(list, lottoNumber) != 1 || list.size() != Lotto.NUMBER_COUNT) {
                return false;
            }
        }
        return true;
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
            int isBonusContained = isBonusContained(lotto);
            if(matchCount == Rank.SECOND.getCountOfMatch()) {
                return isBonusContained == 1 ? Rank.SECOND : Rank.THIRD;
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

    private int isBonusContained(Lotto lotto) {
        return lotto.contains(bonus);
    }
}
