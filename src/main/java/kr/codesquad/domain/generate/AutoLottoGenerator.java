package kr.codesquad.domain.generate;

import kr.codesquad.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AutoLottoGenerator  {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final List<Integer> cachedLottoNum = new ArrayList<>();
    static {
        for (int i = LOTTO_START_NUMBER; i <= LOTTO_LAST_NUMBER; i++) {
            cachedLottoNum.add(i);
        }
    }
    public static List<Lotto> generateLottos(int count) {
        List<Lotto> autoLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            autoLottos.add(generateAuto());
        }
        return autoLottos;
    }

    public static Lotto generateAuto(){
        Collections.shuffle(cachedLottoNum);
        return Lotto.of(cachedLottoNum.subList(0,6));
    }
}
