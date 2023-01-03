package kr.codesquad.LottoService;

import kr.codesquad.LottoService.LottoFactory.LottoFactory;
import kr.codesquad.Rank;

import java.util.*;

public class LottoStore {
    private final LottoFactory lottoFactory;
    private List<Lotto> lottoList;
    private Map<String, Integer> winningLottoMap;

    public LottoStore(LottoFactory lottoFactory, List<Lotto> lottoList, Map<String, Integer> winningLottoMap) {
        this.lottoFactory = lottoFactory;
        this.lottoList = lottoList;
        this.winningLottoMap = winningLottoMap;
        for (Rank rank : Rank.values()){
            winningLottoMap.put(rank.toString(), 0);
        }
    }

    public void setAutomaticLotto(long automaticLottoCount) {
        for (long i = 0; i < automaticLottoCount; i++) {
            Lotto currLotto = lottoFactory.generateLotto("automatic");
            lottoList.add(currLotto);
        }
    }

    public void setManualLotto(long manualLottoCount) {

    }

    public Map<String, Integer> getwinningLottoMap() {
        return winningLottoMap;
    }

    public List<Lotto> getLottos() {
        return lottoList;
    }

    public void setWinningNumbers(List<Integer> wonNumberList, int bonusNumber){
        Set<Integer> wonNumberSet = new HashSet<>(wonNumberList);
        for (Lotto lotto : lottoList) {
            String currRank = lotto.getMatchRank(wonNumberSet, bonusNumber).toString();
            winningLottoMap.put(currRank, winningLottoMap.get(currRank) + 1);
        }
    }

    public void calculateEarningRate(long lottoCount){
        long earningSum = 0;
        for (Rank rank :Rank.values()){
            earningSum += (long) rank.getWinningMoney() / 1000 * winningLottoMap.get(rank.toString());
        }
        float earningRate = 0;
        if (lottoCount != 0) {
            earningRate = (earningSum - lottoCount)/(float)lottoCount * 100;
        }
        System.out.printf("총 수익률은 %.2f%%입니다.", Math.ceil(earningRate * 100)/100);
    }
}
