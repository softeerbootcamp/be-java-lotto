package kr.codesquad.lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    public static final int LOTTO_PRICE = 1000;
    private List<Integer> numberList;

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
