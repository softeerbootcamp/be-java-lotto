package kr.codesquad.lotto;

import java.util.*;

public class AutoLottoGenerator {

    private static final List<LottoNumber> lottoNumbers;

    static {
        lottoNumbers = new ArrayList<>(45);
        for (int idx = 1; idx <= 45; idx++) {
            lottoNumbers.add(new LottoNumber(idx));
        }
    }

    public static List<Lotto> generatorLottos(int cnt) {
        List<Lotto> lottos = new ArrayList<>(cnt);

        for (int idx = 0; idx < cnt; idx++) {
            lottos.add(new Lotto(shuffle()));
        }

        return lottos;
    }

    private static Set<LottoNumber> shuffle() {
        List<LottoNumber> newLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.shuffle(newLottoNumbers);
        return new HashSet<>(newLottoNumbers.subList(0, 6));
    }
}
