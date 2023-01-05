package kr.codesquad.Model;

import java.util.*;

public class WinnerCalculator {   //당첨자 계산기

    public Map<Price, Integer> winnerCount = new HashMap<>();   //등수별 당첨자 수 => 로또 추첨기에서 관리

    public void initWinnerCount(){
        for (Price price:Price.values()){
            winnerCount.put(price,0);
        }
    }

    public void calcResult(User user, WinLotto winLotto){
        List<Integer> winList = Arrays.asList(winLotto.num);
        List<Lotto> lottoList = user.lottoList;
        for (Lotto lotto : lottoList) {
            List<Integer> lottoNum = new ArrayList<Integer>(Arrays.asList(lotto.num));
            lottoNum.retainAll(winList);
            int countOfMatch = lottoNum.size(); //일치 갯수
            Price price = Price.valueOf(countOfMatch, bonusMatch(lotto, winLotto));
            if (price == null) continue;
            updateWinnerCount(price);
            user.updateEarn(price);
        }
    }

    public void updateWinnerCount(Price price){
        int value = winnerCount.get(price)+1;
        winnerCount.put(price, value);
    }

    public boolean bonusMatch(Lotto lotto, WinLotto winLotto) {
        return Arrays.asList(lotto.num).contains(winLotto.bonus);
    }
}
