package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<List<Integer>> numbers;

    Lotto() {
        this.numbers = new ArrayList<>();
    }
    public long calculateCount(long money) {
        return money / 1000;
    }

}
