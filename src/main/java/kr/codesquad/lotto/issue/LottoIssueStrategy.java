package kr.codesquad.lotto.issue;

import kr.codesquad.lotto.Lotto;

import java.util.List;

public interface LottoIssueStrategy {
    List<Lotto> issue(int cnt);
}
