package kr.codesquad;

import java.io.IOException;
import java.util.*;

public class LottoIssueImpl implements LottoIssue {

    @Override
    public List<Lotto> issue(LottoIssueStrategy strategy, int cnt) throws IOException {
        return strategy.issue(cnt);
    }
}
