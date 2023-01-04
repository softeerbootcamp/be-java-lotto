package kr.codesquad;

import java.util.List;

public interface LottoIssueStrategy {
    List<Lotto> issue(int cnt);
}
