package kr.codesquad.lotto.issue;

import kr.codesquad.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("AutoLottoIssueStrategy Test")
public class AutoLottoIssueStrategyTest {

    private final AutoLottoIssueStrategy strategy = new AutoLottoIssueStrategy();

    @Test
    @DisplayName("issue - 개수에 맞는 로또 발급 테스트")
    void testIssue() {
        // given
        int lottoCnt = 5;

        // when
        List<Lotto> lottos = strategy.issue(lottoCnt);

        // then
        assertEquals(lottoCnt, lottos.size());
    }
}
