package kr.codesquad.domain;

import java.util.List;

public class Lotto2 {

    private List<Integer> lottoNumbers;

    public Lotto2(List<Integer> lotto) {
        this.lottoNumbers = lotto;
    }

    public static Lotto2 of(List<Integer> lotto) {
        return new Lotto2(lotto);
    }

    public int match(Lotto2 another) {
        int count = 0;
        for (Integer lottoNumber : another.lottoNumbers) {
            count += isContains(lottoNumber);
        }
        return count;
    }

    private int isContains(int number) {
        if (lottoNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    public boolean isContainsBonusBall(int bonusBall) {
        return lottoNumbers.contains(bonusBall);
    }
}
