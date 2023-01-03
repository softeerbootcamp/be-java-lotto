package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class generateMyLottoByCount {
    private List<EmptyLotto> lottos;

    public generateMyLottoByCount(int lotto_cnt) {
        generate(lotto_cnt);
    }

    public List<EmptyLotto> getLottos() {
        return this.lottos;
    }

    public void generate(int lotto_cnt) {
        lottos = new ArrayList<>(lotto_cnt);
        Utility ut = new Utility();
        for (int j = 0; j < lotto_cnt; j++) {
            EmptyLotto emptyLotto = new EmptyLotto(ut.retRandLottoNum());
            lottos.add(emptyLotto);
            emptyLotto.printNumbers();
        }
    }
}
