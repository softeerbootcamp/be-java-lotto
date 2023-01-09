package kr.codesquad.model.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("로또 2개를 비교하여 일치하는 개수를 반환하는지 검증한다.")
    void compare() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 10, 11, 12, 13, 14));

        int result = lotto1.compare(lotto2);

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("로또의 특정 숫자 포함 여부를 반환하는지 검증한다.")
    void contains() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        boolean resultTrue = lotto.contains(1);
        boolean resultFalse = lotto.contains(45);

        assertThat(resultTrue).isEqualTo(true);
        assertThat(resultFalse).isEqualTo(false);
    }
}