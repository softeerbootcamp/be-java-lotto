package kr.codesquad.model;

import kr.codesquad.model.lotto.Lotto;
import kr.codesquad.util.error.MoneyErrorMessage;
import kr.codesquad.util.error.TicketErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    @DisplayName("구매금액을 기반으로 수동티켓 구매")
    void purchaseAutoTickets() {
        //given
        Money money = new Money(Lotto.TICKET_PER_PRICE * 10);
        int manualTicketCount =  3;
        //when
        int autoTicketCount = Ticket.purchaseAutoTickets(money, manualTicketCount);
        //then
        int totalTickets = money.getPurchaseMoney() / Lotto.TICKET_PER_PRICE;
        assertThat(autoTicketCount+manualTicketCount).isEqualTo(totalTickets);
    }

    @Test
    @DisplayName("수동티켓을 0장보다 작게 구매하는 경우")
    void purchaseManualTicketUnderZero() {
        //given
        Money money = new Money(Lotto.TICKET_PER_PRICE * 10);
        int manualTicketCount =  -1;
        //when
        //then
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Ticket.purchaseAutoTickets(money, manualTicketCount));
        assertThat(e.getMessage()).isEqualTo(TicketErrorMessage.NOT_TICKET_COUNT_NEGATIVE);
    }

    @Test
    @DisplayName("수동티켓을 0장 구매하는경우")
    void purchaseManualTicketZero() {
        //given
        Money money = new Money(Lotto.TICKET_PER_PRICE * 10);
        int manualTicketCount =  0;
        //when
        //then
        assertDoesNotThrow(()->{
            Ticket.purchaseAutoTickets(money, manualTicketCount);
        });
    }

    @Test
    @DisplayName("수동티켓을 구입금액보다 크게 구매하는경우")
    void purchaseOverMoney() {
        //given
        Money money = new Money(Lotto.TICKET_PER_PRICE * 10);
        int manualTicketCount =  11;
        //when
        //then
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Ticket.purchaseAutoTickets(money, manualTicketCount));
        assertThat(e.getMessage()).isEqualTo(TicketErrorMessage.NOT_AVAIL_MANUAL_TICKET);
    }
}