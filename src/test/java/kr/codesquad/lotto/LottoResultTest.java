package kr.codesquad.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LottoResult Test")
public class LottoResultTest {

    private LottoResult lottoResultOfHas20000Prize() {
        LottoResult lottoResult = new LottoResult(10000);
        for (int idx = 0; idx < 4; idx++) {
            lottoResult.putRank(Rank.FIFTH);
        }
        return lottoResult;
    }

    @Test
    @DisplayName("prize - 총 수익 테스트")
    void testPrize() {
        // given
        LottoResult lottoResult = lottoResultOfHas20000Prize();

        // when
        int prize = lottoResult.prize();

        // then
        assertEquals(20000, prize);
    }

    @Test
    @DisplayName("profitRate - 총 수익률 테스트")
    void testProfitRate() {
        // given (purchase => 10000₩)
        LottoResult lottoResult = lottoResultOfHas20000Prize();

        // when
        double profitRate = lottoResult.profitRate();

        // then
        assertEquals(100.00, profitRate);
    }
}
