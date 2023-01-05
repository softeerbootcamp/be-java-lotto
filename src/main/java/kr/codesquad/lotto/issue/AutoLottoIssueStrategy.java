package kr.codesquad.lotto.issue;

import kr.codesquad.lotto.Lotto;
import kr.codesquad.lotto.LottoNumber;

import java.util.*;

public class AutoLottoIssueStrategy implements LottoIssueStrategy {

    private final List<LottoNumber> lottoNumbers;

    public AutoLottoIssueStrategy() {
        this.lottoNumbers = new ArrayList<>(45);
        for (int idx = 1; idx <= 45; idx++) lottoNumbers.add(new LottoNumber(idx));
    }

    @Override
    public List<Lotto> issue(int cnt) {
        List<Lotto> lottos = new ArrayList<>(cnt);

        for (int idx = 0; idx < cnt; idx++) {
            lottos.add(new Lotto(shuffle()));
        }

        return lottos;
    }

    private Set<LottoNumber> shuffle() {
        List<LottoNumber> newLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.shuffle(newLottoNumbers);
        return new HashSet<>(newLottoNumbers.subList(0, 6));
    }
}
