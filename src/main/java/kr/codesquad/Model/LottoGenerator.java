//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package kr.codesquad.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public LottoGenerator() {
    }

    public Lotto getNewLotto() {
        List<Integer> lottoNum = Lotto.lottoNum;
        Collections.shuffle(lottoNum);
        List<Integer> lottoNumList = this.setLottoNum(lottoNum);
        Lotto lotto = new Lotto(lottoNumList);
        return lotto;
    }

    private List<Integer> setLottoNum(List<Integer> lottoNum) {
        List<Integer> number = new ArrayList();

        for(int i = 0; i < 6; ++i) {
            number.add((Integer)lottoNum.get(i));
        }

        return number;
    }
}
