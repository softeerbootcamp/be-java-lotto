package kr.codesquad.lotto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private final Set<LottoNumber> numberSet;

    public Lotto(Set<LottoNumber> numberSet) {
        this.numberSet = numberSet;
    }

    public int countOfMatch(Lotto lotto) {
        int cnt = 0;

        for (LottoNumber lottoNumber: numberSet) {
            if (lotto.contains(lottoNumber)) cnt++;
        }

        return cnt;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.numberSet.contains(lottoNumber);
    }

    public void print() {
        List<Integer> numberList = numberSet.stream().map(LottoNumber::getNumber).collect(Collectors.toList());
        System.out.println(numberList);
    }
}
