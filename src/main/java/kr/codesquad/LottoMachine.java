package kr.codesquad;

import java.util.*;

public class LottoMachine {

    private final Set<Integer> numSet;
    private int price = 1000;

    public LottoMachine(int price) {
        this.numSet = new HashSet<>(45);
        for (int idx = 1; idx <= 45; idx++) numSet.add(idx);
        this.price = price;
    }

    private List<Integer> shuffle() {
        List<Integer> numberList = new ArrayList<>(numSet);
        Collections.shuffle(numberList);
        return numberList.subList(0, 6);
    }
}
