package kr.codesquad;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    final static int LOTTO_LENGTH = 6;  // 로또 번호 조합의 길이

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

    public static void printSequence(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {  // 생성된 로또 번호 출력
            System.out.println(lotto);
        }
    }

    @Override
    public String toString() {
        return lotto.stream().sorted().collect(Collectors.toList()).toString();
    }
}
