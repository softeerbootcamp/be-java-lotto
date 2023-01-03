package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;

public class MyLotto {
    private int lotto_cnt;
    private ArrayList<EmptyLotto> my_lottos;
    private ArrayList<Integer> allLottoNum;

    public MyLotto(int lotto_cnt) {
        setLottoCnt(lotto_cnt);
        setAllLottoNum();
        setMyLottos();
    }

    public ArrayList<EmptyLotto> getMy_lottos() {
        return this.my_lottos;
    }

    public void setLottoCnt(int lotto_cnt) {
        this.lotto_cnt = lotto_cnt;
    }

    public void setAllLottoNum() {
        this.allLottoNum = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            this.allLottoNum.add(i);
        }
    }

    public ArrayList<Integer> retRandLottoNum() {
        Collections.shuffle(this.allLottoNum);
        ArrayList<Integer> lottoNums = new ArrayList<>(Lotto_Info.LOTTO_SIZE.getValue());
        for (int i = 0; i < Lotto_Info.LOTTO_SIZE.getValue(); i++) {
            lottoNums.add(this.allLottoNum.get(i));
        }
        return lottoNums;
    }

    public void setMyLottos() {
        my_lottos = new ArrayList<>(lotto_cnt);
        for (int j = 0; j < lotto_cnt; j++) {
            EmptyLotto emptyLotto = new EmptyLotto(retRandLottoNum());
            my_lottos.add(emptyLotto);
            emptyLotto.printNumbers();
        }
    }
}
