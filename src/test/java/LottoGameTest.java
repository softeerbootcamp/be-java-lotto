import kr.codesquad.Model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    @Test
    public void match_4등_1장_5등_2장() {
        LottoGame lottoGame = new LottoGame(0, 5, createTestLottos());

        WinningLotto winningLotto =
                new WinningLotto(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);

        LottoResult result = lottoGame.match(winningLotto);

        assertThat(result.getValue(Rank.FOURTH)).isEqualTo(1);
        assertThat(result.getValue(Rank.FIFTH)).isEqualTo(2);
        assertThat(result.getPrize()).usingRecursiveComparison().isEqualTo(new Money(Rank.FOURTH.getWinningMoney() + Rank.FIFTH.getWinningMoney()*2));
    }

    private List<Lotto> createTestLottos() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.of(Arrays.asList(1, 2, 3, 4, 11, 12)));
        lottos.add(Lotto.of(Arrays.asList(1, 2, 3, 10, 11, 12)));
        lottos.add(Lotto.of(Arrays.asList(1, 2, 3, 10, 11, 13)));
        lottos.add(Lotto.of(Arrays.asList(1, 2, 9, 10, 11, 13)));
        lottos.add(Lotto.of(Arrays.asList(1, 2, 19, 20, 21, 22)));
        return lottos;
    }
}
