package kr.codesquad.lotto;

import kr.codesquad.lotto.io.LottoIOManager;
import kr.codesquad.lotto.io.LottoIOManagerImpl;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoGenerator {
    private static final LottoIOManager io;

    static {
        io = new LottoIOManagerImpl();
    }

    public static List<Lotto> generatorLottos(int cnt) {
        List<Lotto> lottos = new ArrayList<>(cnt);
        int lottoCnt = io.readLottoCount("수동으로 구매할 로또 수를 입력해 주세요.");

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int idx = 0; idx < lottoCnt; idx++) {
            lottos.add(new Lotto(io.readLottoNumbers("")));
        }

        return lottos;
    }
}
