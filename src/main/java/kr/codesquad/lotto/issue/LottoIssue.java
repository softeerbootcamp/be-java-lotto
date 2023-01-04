package kr.codesquad.lotto.issue;

import kr.codesquad.lotto.Lotto;

import java.io.IOException;
import java.util.List;

public interface LottoIssue {
    List<Lotto> issue(int cnt) throws IOException;
    void setLottoIssueStrategy(LottoIssueStrategy strategy);
}
