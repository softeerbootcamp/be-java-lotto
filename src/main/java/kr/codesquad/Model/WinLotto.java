package kr.codesquad.Model;

import java.util.List;

public class WinLotto extends Lotto {
    public int bonus = -1;

    public WinLotto(List<Integer> lottoNum, int bonus) {
        super(lottoNum);
        this.bonus = bonus;
    }
}
