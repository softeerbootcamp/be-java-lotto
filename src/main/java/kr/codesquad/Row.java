package kr.codesquad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Row {

    int result;
    List<Integer> values = new ArrayList<>();

    public void shuffle() {
        Collections.shuffle(values);
    }

    /**
     * 각 list 별 정답과 일치하는 갯수 반환
     *
     * @param answers
     */
    public void compare(int[] answers) {
        for (int answer : answers) {
            compare2(answer);
        }
    }

    public void compare2(int answer) {
        if (values.contains(answer)) {
            result++;
        }
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }
}
