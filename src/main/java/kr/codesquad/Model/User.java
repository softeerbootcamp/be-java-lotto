package kr.codesquad.Model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class User {
    private BigInteger money;
    private int lottoAmount;
    private int autoLottoAmount;
    private int manualLottoAmount;
    public List<Lotto> lottoList = new ArrayList();
    public BigDecimal earn = new BigDecimal("-100");

    public User(BigInteger money) {
        this.money = money;
        getLottoAmount();
    }

    public int getLottoAmount() {
        lottoAmount = money.divide(new BigInteger(Lotto.LOTTO_PRICE)).intValue();
        autoLottoAmount = money.divide(new BigInteger(Lotto.LOTTO_PRICE)).intValue();
        return lottoAmount;
    }

    public void buyLotto(LottoGenerator lottoGenerator) {
        for(int i = 0; i < autoLottoAmount; ++i) {
            Lotto lotto = lottoGenerator.getNewLotto();
            lottoList.add(lotto);
        }
    }

    public void buyLotto(LottoGenerator manualLottoGenerator, List<Integer> manualLottoNumbers){   //수동 구입
        manualLottoAmount++;
        autoLottoAmount--;
        Lotto lotto = manualLottoGenerator.getNewLotto(manualLottoNumbers);
        lottoList.add(lotto);
    }

    public void updateEarn(Price price) {
        earn = earn.add(new BigDecimal(price.getWinningMoney() / (double)this.money.intValue() * 100.0));
    }
}
