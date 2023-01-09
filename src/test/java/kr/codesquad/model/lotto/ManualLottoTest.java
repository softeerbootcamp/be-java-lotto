package kr.codesquad.model.lotto;

import kr.codesquad.model.Ticket;
import kr.codesquad.util.error.LottoErrorMessage;
import kr.codesquad.util.error.TicketErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ManualLottoTest {
    @Test
    @DisplayName("중복숫자 예외처리 테스트")
    void duplicateNumber() {
        //given
        List<Integer> duplicateNumber = Arrays.asList(1, 2, 3, 3, 4, 5);
        //when,then
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new ManualLotto(duplicateNumber));
        assertThat(e.getMessage()).isEqualTo(LottoErrorMessage.DUPLICATE_NUMBER);
    }



}