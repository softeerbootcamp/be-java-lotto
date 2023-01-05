package kr.codesquad.lotto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() < 6) {
            throw new IllegalArgumentException("로또 번호는 서로 다른 6개의 번호로 구성되어야 합니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public int countOfMatch(Lotto lotto) {
        int cnt = 0;

        for (LottoNumber lottoNumber: lottoNumbers) {
            if (lotto.contains(lottoNumber)) cnt++;
        }

        return cnt;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public void print() {
        List<Integer> numbers = lottoNumbers.stream().map(LottoNumber::number).collect(Collectors.toList());
        System.out.println(numbers);
    }
}
