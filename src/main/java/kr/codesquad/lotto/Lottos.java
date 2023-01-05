package kr.codesquad.lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    public final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
