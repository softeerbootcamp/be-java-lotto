package kr.codesquad;

import java.util.List;

public interface LottoIssue {
    List<Lotto> issue(LottoIssueStrategy strategy, int cnt);
}
