package kr.codesquad.lotto.issue;

import kr.codesquad.lotto.Lotto;

import java.util.List;

public interface LottoIssue {
    List<Lotto> issue(int cnt);
    void setLottoIssueStrategy(LottoIssueStrategy strategy);
}
