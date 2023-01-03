package kr.codesquad;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    final static int LOTTO_LENGTH = 6;  // 로또 번호 조합의 길이
    // TODO: 보너스 번호?

    private Set<Integer> lotto;

    public Lotto(Set<Integer> lotto) {
        // TODO: LOTTO_LENGTH 길이 다르면 Exception
        this.lotto = lotto;
    }

    public Lotto(List<Integer> lotto) {
        // TODO: LOTTO_LENGTH 길이 다르면 Exception
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
        return lotto.toString();
    }
}
