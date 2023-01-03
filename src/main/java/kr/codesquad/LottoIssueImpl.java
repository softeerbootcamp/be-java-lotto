package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class LottoIssueImpl implements LottoIssue {

    private final List<Integer> numList;

    public LottoIssueImpl() {
        this.numList = new ArrayList<>(45);
        for (int idx = 1; idx <= 45; idx++) numList.add(idx);
    }

    @Override
    public List<List<Integer>> issue(int cnt) {
        return null;
    }

    private List<Integer> shuffle() {
        return List.of();
    }
}
