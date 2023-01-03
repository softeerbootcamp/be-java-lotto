package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoIssueImpl implements LottoIssue {

    private final List<Integer> numList;

    public LottoIssueImpl() {
        this.numList = new ArrayList<>(45);
        for (int idx = 1; idx <= 45; idx++) numList.add(idx);
    }

    @Override
    public List<List<Integer>> issue(int cnt) {
        List<List<Integer>> lottoList = new ArrayList<>(cnt);
        for (int idx = 0; idx < cnt; idx++) {
            lottoList.add(shuffle());
        }
        System.out.println(cnt + "개를 구매했습니다.");
        lottoList.forEach(System.out::println);
        return lottoList;
    }

    private List<Integer> shuffle() {
        List<Integer> numberList = new ArrayList<>(numList);
        Collections.shuffle(numberList);
        return numberList.subList(0, 6);
    }
}
