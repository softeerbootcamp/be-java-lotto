package lotto.domain;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.exception.NumberCountException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoTest {
    @Test
    public void testLottoMatch(){
        Lotto userLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 7));
        int result = winningLotto.match(userLotto);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void testOfComma(){
        Lotto userLotto = Lotto.ofComma("1,2,3,4,5,6");
        Lotto winningLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        int result = userLotto.match(winningLotto);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void testDuplicateNumberString(){
        assertThrows(NumberCountException.class, ()-> Lotto.ofComma("1,2,3,4,5,5"));
    }

    @Test
    public void testDuplicateNumberList(){
        assertThrows(NumberCountException.class, () -> Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 5)));
    }
}
