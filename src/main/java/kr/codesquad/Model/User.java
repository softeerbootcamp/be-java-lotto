package kr.codesquad.Model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class User {
    private BigInteger money;
    private int lottoAmount;
    public List<Lotto> lottoList = new ArrayList();
    public BigDecimal earn = new BigDecimal("-100");

    public User(BigInteger money) {
        this.money = money;
        this.getLottoAmount();
    }

    public int getLottoAmount() {
        this.lottoAmount = this.money.divide(new BigInteger(Lotto.LOTTO_PRICE)).intValue();
        return this.lottoAmount;
    }

    public void buyLotto(LottoGenerator lottoGenerator) {
        for(int i = 0; i < this.lottoAmount; ++i) {
            Lotto lotto = lottoGenerator.getNewLotto();
            this.lottoList.add(lotto);
        }

    }

    public void updateEarn(Price price) {
        this.earn = this.earn.add(new BigDecimal(price.getWinningMoney() / (double)this.money.intValue() * 100.0));
    }
}
