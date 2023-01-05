package kr.codesquad.LottoService;

import kr.codesquad.LottoService.LottoFactory.LottoFactory;
import kr.codesquad.Rank;

import java.util.*;

public class LottoStore {
    private final LottoFactory lottoFactory;
    private static final int LOTTO_PRICE=1000;
    private static final int HUNDRED=100;

    private List<Lotto> lottoList;
    private Map<Rank, Integer> winningLottoMap;

    public LottoStore(LottoFactory lottoFactory, List<Lotto> lottoList, Map<Rank, Integer> winningLottoMap) {
        this.lottoFactory = lottoFactory;
        this.lottoList = lottoList;
        this.winningLottoMap = winningLottoMap;
        for (Rank rank : Rank.values()){
            winningLottoMap.put(rank, 0);
        }
    }

    public void setAutomaticLotto(long automaticLottoCount) {
        for (long i = 0; i < automaticLottoCount; i++) {
            Lotto currLotto = lottoFactory.generateLotto("automatic");
            lottoList.add(currLotto);
        }
    }

    public void setManualLotto(long manualLottoCount) {
        for (long i = 0 ; i < manualLottoCount ; i++){
            Lotto currLotto = lottoFactory.generateLotto("manual");
            lottoList.add(currLotto);
        }
    }

    public Map<Rank, Integer> getwinningLottoMap() {
        return winningLottoMap;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public void setWinningNumbers(List<Integer> wonNumberList, int bonusNumber){
        Set<Integer> wonNumberSet = new HashSet<>(wonNumberList);
        for (Lotto lotto : lottoList) {
            Rank currRank = lotto.getMatchRank(wonNumberSet, bonusNumber);
            winningLottoMap.put(currRank, winningLottoMap.get(currRank) + 1);
        }
    }

    public void calculateEarningRate(long lottoCount){
        long earningSum = 0;
        for (Rank rank :Rank.values()){
            earningSum += (long) rank.getWinningMoney() / LOTTO_PRICE * winningLottoMap.get(rank);
        }
        float earningRate = 0;
        if (lottoCount != 0) {
            earningRate = (earningSum - lottoCount)/(float)lottoCount * HUNDRED;
        }
        System.out.printf("총 수익률은 %.2f%%입니다.", Math.ceil(earningRate * HUNDRED)/HUNDRED);
    }
}
