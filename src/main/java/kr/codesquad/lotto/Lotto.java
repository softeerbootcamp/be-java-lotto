package kr.codesquad.lotto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private final Set<LottoNumber> numbers;

    public Lotto(Set<LottoNumber> numbers) {
        if (numbers.size() < 6) {
            throw new IllegalArgumentException("로또 번호는 서로 다른 6개의 번호로 구성되어야 합니다.");
        }
        this.numbers = numbers;
    }

    public int countOfMatch(Lotto lotto) {
        int cnt = 0;

        for (LottoNumber lottoNumber: numbers) {
            if (lotto.contains(lottoNumber)) cnt++;
        }

        return cnt;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber);
    }

    public void print() {
        List<Integer> numberList = numbers.stream().map(LottoNumber::getNumber).collect(Collectors.toList());
        System.out.println(numberList);
    }
}
