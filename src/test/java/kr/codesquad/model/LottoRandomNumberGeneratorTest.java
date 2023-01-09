package kr.codesquad.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRandomNumberGeneratorTest {

    @Test
    @DisplayName("로또 번호 랜덤 생성기가 1부터 45 범위의 중복되지 않는 숫자 6개를 생성하는지 검증한다.")
    void generate() {
        LottoRandomNumberGenerator generator = new LottoRandomNumberGenerator();

        List<Integer> result = generator.generate();

        for (int number : result) {
            assertThat(number).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(45);
        }
        assertThat(result).hasSize(6);
        assertThat(result).doesNotHaveDuplicates();
    }
}