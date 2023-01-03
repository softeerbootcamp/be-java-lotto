package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class Row {

    private int match;
    private List<Integer> values = new ArrayList<>();
    private boolean isBonus;

    /**
     * 각 list 별 정답과 일치하는 갯수 반환
     */
    public void compare(int[] answers, int bonusNumber) {

        for (int answer : answers) {
            compareNumber(answer);
        }
        compareBonusNumber(bonusNumber);
    }

    public void compareNumber(int answer) {
        if (this.values.contains(answer)) {
            match++;
        }
    }

    public void compareBonusNumber(int bonusNumber) {
        this.isBonus = this.values.contains(bonusNumber);
    }

    public void addValues(List<Integer> num) {
        values.addAll(num);
    }

    public int getMatch() {
        return match;
    }

    public List<Integer> getValues() {
        return values;
    }

    public boolean isBonus() {
        return isBonus;
    }
}
