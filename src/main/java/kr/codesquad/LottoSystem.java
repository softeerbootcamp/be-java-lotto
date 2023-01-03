package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class LottoSystem {
    private final List<Integer> numList;

    public LottoSystem() {
        this.numList = new ArrayList<>();
        for(int i = 1;i <= 45;i++) this.numList.add(i);
    }
}
