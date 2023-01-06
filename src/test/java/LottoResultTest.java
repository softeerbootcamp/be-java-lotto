import kr.codesquad.Lotto;
import kr.codesquad.LottoResult;
import kr.codesquad.Money;
import kr.codesquad.WinningLotto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoResultTest {

    @Test
    public void Fifth() { // 3개
        // when
        List<Lotto> lottos = new ArrayList<Lotto>() {
            {
                add(new Lotto(Arrays.asList(1, 2,3,31,32,33)));
                add(new Lotto(Arrays.asList(1, 2,4,7,11,44)));
                add(new Lotto(Arrays.asList(2, 12,24,30,31,43)));
            }
        };

        // given
        LottoResult result = new LottoResult(
                new WinningLotto(new ArrayList<>(Arrays.asList(1, 2, 3, 21, 22, 23)),24),
                lottos,
                new Money(3000));

        // then
        result.showResults();
    }

    @Test
    public void Fourth() {  // 4개
        // when
        List<Lotto> lottos = new ArrayList<Lotto>() {
            {
                add(new Lotto(Arrays.asList(1, 2,3,31,32,33)));
                add(new Lotto(Arrays.asList(1, 2,4,7,11,44)));
                add(new Lotto(Arrays.asList(2, 12,24,30,31,43)));
            }
        };

        // given
        LottoResult result = new LottoResult(
                new WinningLotto(new ArrayList<>(Arrays.asList(1, 2, 3, 31, 22, 23)),24),
                lottos,
                new Money(3000));

        // then
        result.showResults();
    }

    @Test
    public void Third() {  // 5개
        // when
        List<Lotto> lottos = new ArrayList<Lotto>() {
            {
                add(new Lotto(Arrays.asList(1, 2, 3, 31, 32, 33)));
                add(new Lotto(Arrays.asList(1, 2, 4, 7, 11, 44)));
                add(new Lotto(Arrays.asList(2, 12, 24, 30, 31, 43)));
            }
        };

        // given
        LottoResult result = new LottoResult(
                new WinningLotto(new ArrayList<>(Arrays.asList(1, 2, 3, 31, 32, 23)),24),
                lottos,
                new Money(3000));

        // then
        result.showResults();
    }

    @Test
    public void Second() { // 5개 + 보너스
        // when
        List<Lotto> lottos = new ArrayList<Lotto>() {
            {
                add(new Lotto(Arrays.asList(1, 2, 3, 31, 32, 33)));
                add(new Lotto(Arrays.asList(1, 2, 4, 7, 11, 44)));
                add(new Lotto(Arrays.asList(2, 12, 24, 30, 31, 43)));
            }
        };

        // given
        LottoResult result = new LottoResult(
                new WinningLotto(new ArrayList<>(Arrays.asList(1, 2, 3, 31, 32, 23)),33),
                lottos,
                new Money(3000));

        // then
        result.showResults();
    }

    @Test
    public void First() { // 6개
// when
        List<Lotto> lottos = new ArrayList<Lotto>() {
            {
                add(new Lotto(Arrays.asList(1, 2, 3, 31, 32, 33)));
                add(new Lotto(Arrays.asList(1, 2, 4, 7, 11, 44)));
                add(new Lotto(Arrays.asList(2, 12, 24, 30, 31, 43)));
            }
        };

        // given
        LottoResult result = new LottoResult(
                new WinningLotto(new ArrayList<>(Arrays.asList(1, 2, 3, 31, 32, 33)),7),
                lottos,
                new Money(3000));

        // then
        result.showResults();
    }
}
