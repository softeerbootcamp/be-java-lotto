package kr.codesquad;

import kr.codesquad.domain.Lotto2;
import kr.codesquad.domain.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoGenerator implements LottoGenerator {

    private List<Integer> kindOfNumbers;

    public AutoLottoGenerator() {
        kindOfNumbers = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            kindOfNumbers.add(i);
        }
    }

    @Override
    public List<Lotto2> generate(Money money) {
        List<Lotto2> lottos = new ArrayList<>();
        for (int i = 0; i < money.calculateLottoCount(); i++) {
            lottos.add(lottoGenerate());
        }
        return lottos;
    }


    public Lotto2 lottoGenerate() {
        Collections.shuffle(kindOfNumbers);
        List<Integer> list = new ArrayList<>(kindOfNumbers.subList(0, 6));
        return new Lotto2(list);
    }
}
