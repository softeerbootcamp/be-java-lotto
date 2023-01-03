package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class generateMyLottoByCount {
    private List<EmptyLotto> lottoList;

    public List<EmptyLotto> getLottoList() {
        return this.lottoList;
    }

    public void generate(int lotto_cnt) {
        lottoList = new ArrayList<>(lotto_cnt);
        Utility ut = new Utility();
        for (int j = 0; j < lotto_cnt; j++) {
            EmptyLotto emptyLotto = new EmptyLotto(ut.retRandLottoNum());
            lottoList.add(emptyLotto);
            emptyLotto.printNumbers();
        }
    }
}
