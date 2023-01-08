package lotto.domain;

import kr.codesquad.domain.LottoNumber;
import kr.codesquad.domain.exception.LottoNumberException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoNumberTest {
    @Test
    public void createLottoNumber(){
        assertThat(LottoNumber.of(1)).isEqualTo(LottoNumber.of("1"));
    }

    @Test
    public void createOutOfRangeLottoNumber(){
        assertThrows(LottoNumberException.class, () -> LottoNumber.of(0));
    }

    @Test
    public void createNullLottoNumber(){
        assertThrows(LottoNumberException.class, () -> LottoNumber.of(null));
    }

    @Test
    public void createNotIntegerLottoNumber(){
        assertThrows(LottoNumberException.class, () -> LottoNumber.of("-a"));
    }
}
