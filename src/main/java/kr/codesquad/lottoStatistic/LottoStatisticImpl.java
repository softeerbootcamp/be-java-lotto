package kr.codesquad.lottoStatistic;

import kr.codesquad.Rank;
import kr.codesquad.lotto.Lotto;
import kr.codesquad.lotto.LottoNumber;

import java.util.List;
import java.util.Map;

public class LottoStatisticImpl implements LottoStatistic{
    @Override
    public Map<Rank, Integer> calculateResult(List<LottoNumber> jackpotLottoNumbers, int bonus, List<Lotto> lottos) {
        Map<Rank, Integer> mp = Rank.initMap();
        for(Lotto lotto : lottos) {
            Rank rank = getRankByMatchCount(jackpotLottoNumbers,lotto,bonus);
            mp.replace(rank, mp.get(rank), mp.get(rank)+1);
        }

        return mp;
    }

    private Rank getRankByMatchCount(List<LottoNumber> jackpotLottoNumbers, Lotto lotto, int bonus) {
        for(Rank rank : Rank.values()) {
            if(lotto.contains(jackpotLottoNumbers) == Rank.SECOND.getCountOfMatch()) {
                return lotto.containsBonus(bonus) ? Rank.SECOND : Rank.THIRD;
            }
            if(lotto.contains(jackpotLottoNumbers) == rank.getCountOfMatch()) {
                return rank;
            }
        }
        return null;
    }
}
