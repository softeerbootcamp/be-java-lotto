package kr.codesquad.Model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {

    private BigInteger money;   //총 로또 구입한 가격
    private int lottoAmount;   //유저가 구입한 로또 갯수
    public List<Lotto> lottoList = new ArrayList<>();   //유저가 구입한 로또
    public BigDecimal earn = new BigDecimal("-100");    //유저의 수익
    public void setMoney(BigInteger money) {
        this.money = money;
    }


    public int buyLotto(){
        lottoAmount = money.divide(new BigInteger("1000")).intValue();
        for (int i=0; i<lottoAmount; i++){
            Lotto lotto = LottoGenerator.generateLotto();
            lotto.print();
            lottoList.add(lotto);
        }
        return lottoAmount;
    }

    public void updateEarn(Price price){
        earn = earn.add(new BigDecimal((price.getWinningMoney()/money.intValue())*100));
    }   //유저의 수익


}
