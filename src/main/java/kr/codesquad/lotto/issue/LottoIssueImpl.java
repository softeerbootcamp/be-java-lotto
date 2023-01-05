package kr.codesquad.lotto.issue;

import kr.codesquad.lotto.Lotto;

import java.util.*;

public class LottoIssueImpl implements LottoIssue {

    private LottoIssueStrategy strategy;

    public LottoIssueImpl(LottoIssueStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public List<Lotto> issue(int cnt) {
        List<Lotto> lottos = this.strategy.issue(cnt);
        lottos.forEach(Lotto::print);
        return lottos;
    }

    @Override
    public void setLottoIssueStrategy(LottoIssueStrategy strategy) {
        this.strategy = strategy;
    }
}
