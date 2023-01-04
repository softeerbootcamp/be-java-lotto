package kr.codesquad.lotto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private final Set<LottoNumber> numberSet;

    public Lotto(Set<LottoNumber> numberSet) {
        this.numberSet = numberSet;
    }

    public int targetedCount(WinningLotto winningLotto) {
        int cnt = 0;

        for (LottoNumber winningNumber: winningLotto.getNumberList()) {
            if (numberSet.contains(winningNumber)) cnt++;
        }

        return cnt;
    }

    public boolean hasBonus(WinningLotto winningLotto) {
        return numberSet.contains(winningLotto.getBonus());
    }

    public void print() {
        List<Integer> numberList = numberSet.stream().map(LottoNumber::getNumber).collect(Collectors.toList());
        System.out.println(numberList);
    }
}
