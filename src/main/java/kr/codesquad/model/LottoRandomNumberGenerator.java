package kr.codesquad.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandomNumberGenerator implements LottoNumberGenerator {
    @Override
    public List<Integer> generate() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(i);
        }
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, 6);
    }
}
