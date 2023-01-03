package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;

public class My_lotto {
    private int lotto_cnt;
    private ArrayList<Empty_lotto> my_lottos;
    private ArrayList<Integer> all_lotto_num;
    public My_lotto(int lotto_cnt) {
        setLotto_cnt(lotto_cnt);
        setAll_lotto_num();
        this.my_lottos = setMy_lottos(this.lotto_cnt);
    }
    public ArrayList<Empty_lotto> getMy_lottos(){
        return this.my_lottos;
    }
    public void setLotto_cnt(int lotto_cnt) {
        this.lotto_cnt = lotto_cnt;
    }

    public void setAll_lotto_num() {
        this.all_lotto_num = new ArrayList<>();
        for(int i=1;i <= 45;i++){
            this.all_lotto_num.add(i);
        }
    }

    public ArrayList<Integer> retRand_lotto_num() {
        Collections.shuffle(this.all_lotto_num);
        ArrayList<Integer> lottoNums = new ArrayList<>(Lotto_Info.LOTTO_CNT.getValue());
        for (int i = 0; i < Lotto_Info.LOTTO_CNT.getValue(); i++) {
            lottoNums.add(this.all_lotto_num.get(i));
        }
        return lottoNums;
    }

    public ArrayList<Empty_lotto> setMy_lottos(int lotto_cnt) {
        my_lottos = new ArrayList<>(lotto_cnt);
        for (int j=0;j<lotto_cnt;j++) {
            Empty_lotto tmplotto = new Empty_lotto(retRand_lotto_num());
            my_lottos.add(tmplotto);
            tmplotto.printNumbers();
        }

        return my_lottos;
    }
}
