package kr.codesquad.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

    private List<Integer> lottoNumbers;

    public LottoNumberGenerator() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(i);
        }
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> generate() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, 6);
    }
}
