package kr.codesquad.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoAutoFactory implements LottoFactory {

    public final RandomNumFactory randomNumFactory = new RandomNumFactory();

    @Override
    public List<Lotto> buyLotto(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Lotto lotto = new Lotto(randomNumFactory.makeRandomNum());
            lottos.add(lotto);
        }
        return lottos;
    }
}
