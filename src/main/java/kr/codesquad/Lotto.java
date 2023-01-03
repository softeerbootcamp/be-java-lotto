package kr.codesquad;

import java.util.Set;

public class Lotto {

    private final Set<Integer> numberSet;

    public Lotto(Set<Integer> numberSet) {
        this.numberSet = numberSet;
    }

    public int targetedCount(WinningLotto winningLotto) {
        int cnt = 0;

        for (Integer winningNumber: winningLotto.getNumberList()) {
            if (numberSet.contains(winningNumber)) cnt++;
        }

        return cnt;
    }

    public boolean hasBonus(WinningLotto winningLotto) {
        return numberSet.contains(winningLotto.getBonus());
    }

    public void print() {
        System.out.println(numberSet.toString());
    }
}
