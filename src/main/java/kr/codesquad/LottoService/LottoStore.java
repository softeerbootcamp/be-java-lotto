package kr.codesquad.LottoService;

import kr.codesquad.LottoService.LottoFactory.LottoFactory;
import kr.codesquad.Rank;

import java.util.*;

public class LottoStore {
    private final LottoFactory lottoFactory;
    private List<Lotto> lottos;
    private Map<String, Integer> winningLottos;

    public LottoStore(LottoFactory lottoFactory, List<Lotto> lottos, Map<String, Integer> winningLottos) {
        this.lottoFactory = lottoFactory;
        this.lottos = lottos;
        this.winningLottos = winningLottos;
        for (Rank rank : Rank.values()){
            winningLottos.put(rank.toString(), 0);
        }
    }

    public void setAutomaticLotto(long automaticLottoCount) {
        for (long i = 0; i < automaticLottoCount; i++) {
            Lotto currLotto = lottoFactory.generateLotto("automatic");
            lottos.add(currLotto);
        }
    }

    public void setManualLotto(long manualLottoCount) {

    }

    public Map<String, Integer> getWinningLottos() {
        return winningLottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setWinningNumbers(List<Integer> wonNumberList, int bonusNumber){
        Set<Integer> wonNumberSet = new HashSet<>(wonNumberList);
        for (Lotto lotto : lottos) {
            String currRank = lotto.getMatchRank(wonNumberSet, bonusNumber).toString();
            winningLottos.put(currRank, winningLottos.get(currRank) + 1);
        }
    }

    public void calculateEarningRate(long lottoCount){
        long earningSum = 0;
        for (Rank rank :Rank.values()){
            earningSum += (long) rank.getWinningMoney() / 1000 * winningLottos.get(rank.toString());
        }
        float earningRate = 0;
        if (lottoCount != 0) {
            earningRate = (earningSum - lottoCount)/(float)lottoCount * 100;
        }
        System.out.printf("총 수익률은 %.2f%%입니다.", Math.ceil(earningRate * 100)/100);
    }
}
