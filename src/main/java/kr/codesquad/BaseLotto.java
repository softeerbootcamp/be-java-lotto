package kr.codesquad;

import java.util.ArrayList;

public class BaseLotto {
    protected ArrayList<ArrayList<Integer>> lottoList;
    protected int lottoCnt;
    public ArrayList<ArrayList<Integer>> getLottoList(){
        return this.lottoList;
    }
    public Integer getLottoCnt(int amountOfMoney, int manualLottoCount){
        return this.lottoCnt;
    }

}
