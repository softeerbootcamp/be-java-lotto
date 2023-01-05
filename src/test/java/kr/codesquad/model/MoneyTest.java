package kr.codesquad.model;

import kr.codesquad.model.lotto.Lotto;
import kr.codesquad.util.error.MoneyErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    @DisplayName("구입금액이 티케한장 가격보다 낮은경우")
    void underPerTicket() {
        //given
        int purchaseMoney= Lotto.TICKET_PER_PRICE-1;
        //when,then
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Money(purchaseMoney));
        assertThat(e.getMessage()).isEqualTo(MoneyErrorMessage.NOT_OVER_TICKET_PER_PRICE);
    }

    @Test
    @DisplayName("구입금액이 티켓 한장과 같은경우")
    void samePerTicket() {
        //given
        int purchaseMoney=Lotto.TICKET_PER_PRICE;
        //when,then
        assertDoesNotThrow(()->{
            new Money(purchaseMoney);
        });
    }

    @Test
    @DisplayName("구입금액이 티켓 한장으로 나누어 지지 않는경우")
    void notDivide() {
        //given
        int purchaseMoney=Lotto.TICKET_PER_PRICE+Lotto.TICKET_PER_PRICE/2;
        //when,then
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Money(purchaseMoney));
        assertThat(e.getMessage()).isEqualTo(MoneyErrorMessage.NOT_DIVIDE_TICKET_PER_PRICE);
    }

    @Test
    @DisplayName("구입금액이 티켓한장으로 나누어 지는 경우")
    void Divide() {
        //given
        int purchaseMoney=Lotto.TICKET_PER_PRICE*10;
        //when,then
        assertDoesNotThrow(()->{
            new Money(purchaseMoney);
        });
    }

}