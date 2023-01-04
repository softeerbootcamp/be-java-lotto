package kr.codesquad.sequence;

import kr.codesquad.Lotto;
import kr.codesquad.Money;

import java.util.List;

public class ManualSequenceGenerator implements LottosGenerator {
    private List<Lotto> lottos;

    @Override
    public List<Lotto> generate(final int ticketsToGenerate) {
        return this.lottos;
    }

    public ManualSequenceGenerator(List<Lotto> givenLottos) {
        this.lottos = givenLottos;
    }

}
