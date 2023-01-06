package kr.codesquad.lotto.issue;

import kr.codesquad.lotto.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

@DisplayName("ManualLottoIssueStrategy Test")
public class ManualLottoIssueStrategyTest {

    @Test
    @DisplayName("issue - 개수에 맞는 로또 발급 테스트")
    void testIssue() {
        // given
        int lottoCnt = 1;
        Set<LottoNumber> lottoNumbers = Set.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        // TODO: LottoIOManager의 입출력을..
        // given(lottoIOManager.readLottoCount("수동으로 구매할 로또 수를 입력해 주세요.")).willReturn(lottoCnt);
        // given(lottoIOManager.readLottoNumbers("")).willReturn(lottoNumbers);

        // when
//        List<Lotto> lottos = strategy.issue(lottoCnt);

        // then
//        assertEquals(lottoCnt, lottos.size());
    }
}
