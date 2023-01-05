package kr.codesquad.model;

import kr.codesquad.model.lotto.Lotto;
import kr.codesquad.util.error.TicketErrorMessage;

public class Ticket {
    private final int manualTicketsCount;
    private final int autoTicketsCount;

    public Ticket(int manualTicketsCount, int autoTicketsCount) {
        this.manualTicketsCount = manualTicketsCount;
        this.autoTicketsCount = autoTicketsCount;
    }

    public static int purchaseAutoTickets(Money money, int  manualTicketsCount) {
        valid(money, manualTicketsCount);
        int change = money.getPurchaseMoney() - manualTicketsCount * Lotto.TICKET_PER_PRICE;
        int autoTickets = change / Lotto.TICKET_PER_PRICE;
        return autoTickets;
    }

    private static void valid(Money money, int manualTicketsCount) {
        if (!isTicketCountOverZero(manualTicketsCount)) {
            throw new IllegalArgumentException(TicketErrorMessage.NOT_TICKET_COUNT_NEGATIVE);
        }
        if (!isAvailBuyManualTicket(money,manualTicketsCount)) {
            throw new IllegalArgumentException(TicketErrorMessage.NOT_AVAIL_MANUAL_TICKET);
        }

    }

    private static boolean isAvailBuyManualTicket(Money money, int manualTicketsCount) {
        return money.getPurchaseMoney() > manualTicketsCount * Lotto.TICKET_PER_PRICE;
    }

    private static boolean isTicketCountOverZero(int ticketCount) {
        return ticketCount >= 0;
    }


    public int getManualTicketsCount() {
        return manualTicketsCount;
    }

    public int getAutoTicketsCount() {
        return autoTicketsCount;
    }
}
