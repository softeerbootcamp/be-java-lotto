package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Row {

    private int match;
    private List<Integer> values = new ArrayList<>();

    public void shuffle() {
        Collections.shuffle(values);
    }

    /**
     * 각 list 별 정답과 일치하는 갯수 반환
     */
    public void compare(int[] answers) {
        for (int answer : answers) {
            compare2(answer);
        }
    }

    public void compare2(int answer) {
        if (values.contains(answer)) {
            match++;
        }
    }

    public void addValue(int num) {
        values.add(num);
    }

    public int getMatch() {
        return match;
    }

    public List<Integer> getValues() {
        return values;
    }

}
