package kr.codesquad.model;

import kr.codesquad.model.lotto.Lotto;

public class Ticket {
    private final int manualTicketsCount;
    private final int autoTicketsCount;

    public Ticket(int manualTicketsCount, int autoTicketsCount) {
        this.manualTicketsCount = manualTicketsCount;
        this.autoTicketsCount = autoTicketsCount;
    }

    public static int purchaseAutoTickets(Money money, int  manualTicketsCount) {
        int change = money.getPurchaseMoney() - manualTicketsCount * Lotto.TICKET_PER_PRICE;
        int autoTickets = change / Lotto.TICKET_PER_PRICE;
        return autoTickets;
    }


    public int getManualTicketsCount() {
        return manualTicketsCount;
    }

    public int getAutoTicketsCount() {
        return autoTicketsCount;
    }
}
