package kr.codesquad.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("WinningLotto Test")
public class WinningLottoTest {

    private WinningLotto winningLotto() {
        Lotto lotto = new Lotto(Set.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(45)));
        LottoNumber bonus = new LottoNumber(6);
        return new WinningLotto(lotto, bonus);
    }

    private Lotto secondLotto() {
        return new Lotto(Set.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
    }

    private Lotto thirdLotto() {
        return new Lotto(Set.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(7)));
    }

    @Test
    @DisplayName("new WinningLotto - 보너스 번호가 중복인 경우")
    void testNewWinningLottoWhenDupBonusNumber() {
        // given (lotto 1~6)
        Lotto lotto = secondLotto();
        LottoNumber bonus = new LottoNumber(1);

        // when
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> new WinningLotto(lotto, bonus));

        // then
        assertEquals("보너스 번호는 추첨되지 않은 번호만 선택 가능합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("match - 2등인 경우(matched bonus)")
    void testMatchWhenRankIsSecond() {
        // given (lotto <1 ~ 6>, winningLotto <1 ~ 5, 45>)
        Lotto lotto = secondLotto();
        WinningLotto winningLotto = winningLotto();

        // when
        Rank matchRank = winningLotto.match(lotto);

        // then
        assertEquals(Rank.SECOND, matchRank);
    }

    @Test
    @DisplayName("match - 3등인 경우(not matched bonus)")
    void testMatchWhenRankIsThird() {
        // given (lotto <1 ~ 5, 7>, winningLotto <1 ~ 5, 45>)
        Lotto lotto = thirdLotto();
        WinningLotto winningLotto = winningLotto();

        // when
        Rank matchRank = winningLotto.match(lotto);

        // then
        assertEquals(Rank.THIRD, matchRank);
    }
}
