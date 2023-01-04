package kr.codesquad;

import java.util.*;

public class LottoIssueImpl implements LottoIssue {

    @Override
    public List<Lotto> issue(LottoIssueStrategy strategy, int cnt) {
        return strategy.issue(cnt);
    }
}
