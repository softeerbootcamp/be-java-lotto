package kr.codesquad.lotto.issue;

import kr.codesquad.lotto.Lotto;

import java.io.IOException;
import java.util.*;

public class LottoIssueImpl implements LottoIssue {

    private LottoIssueStrategy strategy;

    public LottoIssueImpl(LottoIssueStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public List<Lotto> issue(int cnt) throws IOException {
        List<Lotto> lottoList = this.strategy.issue(cnt);
        lottoList.forEach(Lotto::print);
        return lottoList;
    }

    @Override
    public void setLottoIssueStrategy(LottoIssueStrategy strategy) {
        this.strategy = strategy;
    }
}
