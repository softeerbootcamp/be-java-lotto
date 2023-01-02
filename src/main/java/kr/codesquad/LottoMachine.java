package kr.codesquad;

import java.util.*;

public class LottoMachine {

    private final Set<Integer> numSet;
    private final int price;

    public LottoMachine(int price) {
        this.numSet = new HashSet<>(45);
        for (int idx = 1; idx <= 45; idx++) numSet.add(idx);
        this.price = price;
    }

    public List<List<Integer>> buy(int total) {
        int cnt = total / price;

        List<List<Integer>> lottoList = new ArrayList<>(cnt);
        for (int idx = 0; idx < cnt; idx++) {
            lottoList.add(shuffle());
        }

        return lottoList;
    }

    private List<Integer> shuffle() {
        List<Integer> numberList = new ArrayList<>(numSet);
        Collections.shuffle(numberList);
        return numberList.subList(0, 6);
    }
}
