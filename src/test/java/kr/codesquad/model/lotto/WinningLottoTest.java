package kr.codesquad.model.lotto;

import kr.codesquad.model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

    @Test
    @DisplayName("로또 번호와 당첨 번호를 비교하여 1등 당첨 내용을 반환한다.")
    void compareWithFirstPlaceLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6, 7));

        Rank result = winningLotto.compare(lotto);

        assertThat(result).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호를 비교하여 2등 당첨 내용을 반환한다.")
    void compareWithSecondPlaceLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7, 8));

        Rank result = winningLotto.compare(lotto);

        assertThat(result).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호를 비교하여 3등 당첨 내용을 반환한다.")
    void compareWithThirdPlaceLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8, 10));

        Rank result = winningLotto.compare(lotto);

        assertThat(result).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호를 비교하여 4등 당첨 내용을 반환한다.")
    void compareWithFourthPlaceLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 8, 9, 10));

        Rank result = winningLotto.compare(lotto);

        assertThat(result).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호를 비교하여 5등 당첨 내용을 반환한다.")
    void compareWithFifthPlaceLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));

        Rank result = winningLotto.compare(lotto);

        assertThat(result).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호를 비교하여 NOTHING을 반환한다.")
    void compareWithNonePlaceLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 8, 9, 10, 11));

        Rank result = winningLotto.compare(lotto);

        assertThat(result).isEqualTo(Rank.NOTHING);
    }

}