package kr.codesquad;

import java.util.List;

public class WinningLotto extends Lotto {
    /*
     * 내가 선택한 번호들의 조합을 나타내는 클래스
     */

    final int bonus;

    public WinningLotto(List<Integer> myLotto, int bonus) {
        super(myLotto);  // 실제 로또 번호
        this.bonus = bonus;

        if(myLotto.contains(bonus))
            throw new IllegalArgumentException("보너스 번호와 로또 번호가 중복됩니다.");
    }

}
