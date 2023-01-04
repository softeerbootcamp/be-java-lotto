package kr.codesquad;

import java.io.IOException;
import java.util.List;

public interface LottoIssueStrategy {
    List<Lotto> issue(int cnt) throws IOException;
}
