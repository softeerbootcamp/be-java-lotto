package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final int price;
    private final List<Integer> numList;

    public LottoMachine(int price) {
        this.price = price;
        this.numList = new ArrayList<>();
        for(int i = 1;i <= 45;i++) this.numList.add(i);
    }
}
