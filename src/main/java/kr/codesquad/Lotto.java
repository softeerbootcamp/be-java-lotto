package kr.codesquad;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private Set<Integer> lotto;

    public Lotto(Set<Integer> lotto) {
        if(lotto.size() != 6)
            throw new IllegalArgumentException("로또 번호가 부족합니다");

        this.lotto = lotto;
    }

    public Lotto(List<Integer> lotto) {
        if(lotto.size() != 6)
            throw new IllegalArgumentException("로또 번호가 부족합니다");

        this.lotto = new HashSet<>(lotto);
    }

    public Set<Integer> getLotto() {
        return lotto;
    }

    public boolean contains(Integer lottoNum) {
        return lotto.contains(lottoNum);
    }

    @Override
    public String toString() {
        return lotto.stream().sorted().collect(Collectors.toList()).toString();
    }
}
