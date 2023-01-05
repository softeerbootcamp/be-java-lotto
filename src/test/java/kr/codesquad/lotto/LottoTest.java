package kr.codesquad.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Lotto Test")
public class LottoTest {

    private Lotto goodCaseLotto() {
        Set<LottoNumber> lottoNumbers = Set.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        return new Lotto(lottoNumbers);
    }

    public Lotto notMatchLotto() {
        Set<LottoNumber> lottoNumbers = Set.of(
                new LottoNumber(45), new LottoNumber(44), new LottoNumber(43),
                new LottoNumber(42), new LottoNumber(41), new LottoNumber(40));
        return new Lotto(lottoNumbers);
    }

    @Test
    @DisplayName("new Lotto - LottoNumber가 6개가 아닌 경우 테스트")
    void testNewLottoWhenLottoNumberIsNotEnough() {
        // given
        Set<LottoNumber> lottoNumbers = Set.of(new LottoNumber(1));

        // when
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> new Lotto(lottoNumbers));

        // then
        assertEquals("로또 번호는 서로 다른 6개의 번호로 구성되어야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("countOfMatch - 6개 매치되는 경우")
    void testCountOfMatchWhenMatch() {
        // given
        Lotto lotto = goodCaseLotto();
        Lotto winningLotto = goodCaseLotto();

        // when
        int countOfMatch = lotto.countOfMatch(winningLotto);

        // then
        assertEquals(6, countOfMatch);
    }

    @Test
    @DisplayName("countOfMatch - 하나도 매치되지 않는 경우")
    void testCountOfMatchWhenNotMatch() {
        // given
        Lotto lotto = goodCaseLotto();
        Lotto winningLotto = notMatchLotto();

        // when
        int countOfMatch = lotto.countOfMatch(winningLotto);

        // then
        assertEquals(0, countOfMatch);
    }

    @Test
    @DisplayName("contains - 해당 LottoNumber가 Lotto에 존재하는 경우")
    void testContainsWhenLottoNumberIsExist() {
        // given
        Lotto lotto = goodCaseLotto();
        LottoNumber lottoNumber = new LottoNumber(1);

        // when
        boolean contains = lotto.contains(lottoNumber);

        // then
        assertTrue(contains);
    }

    @Test
    @DisplayName("contains - 해당 LottoNumber가 Lotto에 존재하지 않는 경우")
    void testContainsWhenLottoNumberIsNotExist() {
        // given
        Lotto lotto = goodCaseLotto();
        LottoNumber lottoNumber = new LottoNumber(45);

        // when
        boolean contains = lotto.contains(lottoNumber);

        // then
        assertFalse(contains);
    }
}
