package lotto.domain;

import kr.codesquad.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @Test
    public void match_2등(){
        Lotto userLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 7));
        int result = winningLotto.match(userLotto);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void create_문자열로또() {
        Lotto userLotto = Lotto.ofComma("1,2,3,4,5,6");
        Lotto winningLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        int result = userLotto.match(winningLotto);
        assertThat(result).isEqualTo(6);
    }
}
