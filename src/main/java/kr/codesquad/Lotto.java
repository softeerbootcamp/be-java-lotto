package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<List<Integer>> lottoList;

    public Lotto(List<List<Integer>> lottoList) {
        this.lottoList = lottoList;
    }

    public List<List<Integer>> getLottoList() {
        return this.lottoList;
    }
}
