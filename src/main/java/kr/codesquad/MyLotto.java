package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;

public class MyLotto {
    private ArrayList<EmptyLotto> my_lottos;

    public MyLotto(int lotto_cnt) {
        setMyLottos(lotto_cnt);
    }

    public ArrayList<EmptyLotto> getMy_lottos() {
        return this.my_lottos;
    }


    public void setMyLottos(int lotto_cnt) {
        my_lottos = new ArrayList<>(lotto_cnt);
        Utility ut = new Utility();
        for (int j = 0; j < lotto_cnt; j++) {
            EmptyLotto emptyLotto = new EmptyLotto(ut.retRandLottoNum());
            my_lottos.add(emptyLotto);
            emptyLotto.printNumbers();
        }
    }
}
