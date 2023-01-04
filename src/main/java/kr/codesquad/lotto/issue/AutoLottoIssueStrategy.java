package kr.codesquad.lotto.issue;

import kr.codesquad.lotto.Lotto;
import kr.codesquad.lotto.LottoNumber;

import java.util.*;

public class AutoLottoIssueStrategy implements LottoIssueStrategy {

    private final List<LottoNumber> numList;

    public AutoLottoIssueStrategy() {
        this.numList = new ArrayList<>(45);
        for (int idx = 1; idx <= 45; idx++) numList.add(new LottoNumber(idx));
    }

    @Override
    public List<Lotto> issue(int cnt) {
        List<Lotto> lottoList = new ArrayList<>(cnt);

        for (int idx = 0; idx < cnt; idx++) {
            Lotto lotto = new Lotto(shuffle());
            lottoList.add(lotto);
        }

        return lottoList;
    }

    private Set<LottoNumber> shuffle() {
        List<LottoNumber> numberList = new ArrayList<>(numList);
        Collections.shuffle(numberList);
        return new HashSet<>(numberList.subList(0, 6));
    }
}
