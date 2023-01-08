package lotto.domain;

import kr.codesquad.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoTest {
    public static final String DUPLICATE_ERROR_MESSAGE = "로또에는 서로 다른  6개의 숫자가 필요합니다.";
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
        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
            Lotto.ofComma("1,2,3,4,5,5");});
        assertThat(exception.getMessage()).isEqualTo(DUPLICATE_ERROR_MESSAGE);
    }

    @Test
    public void testDuplicateNumberList(){
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 5)));
        assertThat(exception.getMessage()).isEqualTo(DUPLICATE_ERROR_MESSAGE);
    }
}
