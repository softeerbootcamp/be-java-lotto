//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

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
        Price[] var1 = Price.values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Price price = var1[var3];
            this.winnerCount.put(price, 0);
        }

    }

    public void calcResult(User user, WinLotto winLotto) {
        List<Integer> winList = Arrays.asList(winLotto.num);
        List<Lotto> lottoList = user.lottoList;
        Iterator var5 = lottoList.iterator();

        while(var5.hasNext()) {
            Lotto lotto = (Lotto)var5.next();
            List<Integer> lottoNum = new ArrayList(Arrays.asList(lotto.num));
            lottoNum.retainAll(winList);
            int countOfMatch = lottoNum.size();
            Price price = Price.valueOf(countOfMatch, this.bonusMatch(lotto, winLotto));
            if (price != null) {
                this.updateWinnerCount(price);
                user.updateEarn(price);
            }
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
