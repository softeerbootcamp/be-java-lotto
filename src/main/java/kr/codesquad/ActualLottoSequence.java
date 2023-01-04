package kr.codesquad;

import java.util.List;

public class ActualLottoSequence extends Lotto {
    /*
     * 내가 선택한 번호들의 조합을 나타내는 클래스
     */

    private final int bonus;

    public ActualLottoSequence(List<Integer> myLotto, int bonus) {
        super(myLotto);  // 실제 로또 번호
        this.bonus = bonus;
    }

}
