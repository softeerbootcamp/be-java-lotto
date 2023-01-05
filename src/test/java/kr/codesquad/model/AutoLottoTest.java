package kr.codesquad.model;

import kr.codesquad.model.lotto.AutoLotto;
import kr.codesquad.model.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AutoLottoTest {

    @Test
    @DisplayName("로또 생성 시 사이즈 6체크")
    public void checkLottoSize() {
        //given
        int lottoSize=6;
        //when
        Lotto lotto = new AutoLotto();
        //then
        assertThat(lotto.getNumbers().size()).isEqualTo(lottoSize);
    }

    @Test
    @DisplayName("로또 생성 시  1~45 범위 체크")
    public void checkArrange() {
        //given
        int startNumber=1;
        int endNumber=45;
        //when
        Lotto lotto = new AutoLotto();
        //then
        for (Integer number : lotto.getNumbers()) {
            assertThat(number).isBetween(startNumber, endNumber);
        }
    }

}