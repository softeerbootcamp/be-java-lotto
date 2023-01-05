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
    public User(BigInteger money){
        this.money = money;
        getLottoAmount();
    }


    public int getLottoAmount(){
        lottoAmount = money.divide(new BigInteger("1000")).intValue();
        return lottoAmount;
    }

    public void buyLotto(LottoGenerator lottoGenerator){
        for (int i=0; i<lottoAmount; i++){
            Lotto lotto = lottoGenerator.getNewLotto();
            lottoList.add(lotto);
        }
    }

    public void updateEarn(Price price){
        earn = earn.add(new BigDecimal((price.getWinningMoney()/money.intValue())*100));
    }   //유저의 수익


}
