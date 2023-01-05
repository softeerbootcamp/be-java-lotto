package kr.codesquad.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WinnerCalculator {
    public Map<Price, Integer> winnerCount = new HashMap();

    public WinnerCalculator() {
    }

    public void initWinnerCount() {
        Price[] prices = Price.values();
        for(int i = 0; i < prices.length; ++i) {
            Price price = prices[i];
            this.winnerCount.put(price, 0);
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
            Price price = Price.valueOf(countOfMatch, this.bonusMatch(lotto, winLotto));
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
        int value = (Integer)this.winnerCount.get(price) + 1;
        this.winnerCount.put(price, value);
    }

    public boolean bonusMatch(Lotto lotto, WinLotto winLotto) {
        return Arrays.asList(lotto.num).contains(winLotto.bonus);
    }
}
