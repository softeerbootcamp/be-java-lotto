package kr.codesquad.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WinnerCalculator {
    public Map<Price, Integer> winnerCount = new HashMap<>();

    public void initWinnerCount() {
        for(Price price: Price.values()) {
            winnerCount.put(price, 0);
        }
    }

    public void calcResult(User user, WinLotto winLotto) {
        List<Integer> winList = Arrays.asList(winLotto.num);
        List<Lotto> lottoList = user.lottoList;
        Iterator itr = lottoList.iterator();

        while(itr.hasNext()) {
            Lotto lotto = (Lotto)itr.next();
            List<Integer> lottoNum = new ArrayList(Arrays.asList(lotto.num));
            lottoNum.retainAll(winList);
            int countOfMatch = lottoNum.size();
            Price price = Price.valueOf(countOfMatch, bonusMatch(lotto, winLotto));
            updateResult(price,user);
        }

    }

    private void updateResult(Price price, User user){
        if (price != null) {
            updateWinnerCount(price);
            user.updateEarn(price);
        }
    }

    public void updateWinnerCount(Price price) {
        winnerCount.put(price, winnerCount.get(price) + 1);
    }

    public boolean bonusMatch(Lotto lotto, WinLotto winLotto) {
        return Arrays.asList(lotto.num).contains(winLotto.bonus);
    }
}
