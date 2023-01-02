package kr.codesquad.model;

import java.util.List;

public class WinningLotto extends Lotto {
    public WinningLotto(List<Integer> winningNumbers) {
        this.numbers = winningNumbers;
    }
}
