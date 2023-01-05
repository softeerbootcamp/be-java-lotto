package kr.codesquad.lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private List<Integer> numberList = new ArrayList<>();

    public Lotto(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    @Override
    public String toString() {
        return this.numberList.toString();
    }
}
