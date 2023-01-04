package kr.codesquad;

import java.util.*;

public class AutoLottoIssueStrategy implements LottoIssueStrategy {

    private final List<Integer> numList;

    public AutoLottoIssueStrategy() {
        this.numList = new ArrayList<>(45);
        for (int idx = 1; idx <= 45; idx++) numList.add(idx);
    }

    @Override
    public List<Lotto> issue(int cnt) {
        List<Lotto> lottoList = new ArrayList<>(cnt);

        for (int idx = 0; idx < cnt; idx++) {
            Lotto lotto = new Lotto(shuffle());
            lottoList.add(lotto);
        }

        lottoList.forEach(Lotto::print);
        return lottoList;
    }

    private Set<Integer> shuffle() {
        List<Integer> numberList = new ArrayList<>(numList);
        Collections.shuffle(numberList);
        return new HashSet<>(numberList.subList(0, 6));
    }
}
