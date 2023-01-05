package kr.codesquad.model;

import kr.codesquad.model.lotto.Lotto;

public class Purchase {
    private final int purchaseAmount;
    private final int manualTicketsCount;
    private final int autoTicketsCount;

    public Purchase(int purchaseAmount, int manualTicketsCount, int autoTicketsCount) {
        this.purchaseAmount = purchaseAmount;
        this.manualTicketsCount = manualTicketsCount;
        this.autoTicketsCount = autoTicketsCount;
    }

    public int getAutoTicketsCount() {
        return autoTicketsCount;
    }

    public static int purchaseAutoTickets(int purchaseAmount, int manualTickets) {
        int change = purchaseAmount - manualTickets * Lotto.TICKET_PER_PRICE;
        int autoTickets = change / Lotto.TICKET_PER_PRICE;
        return autoTickets;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getManualTicketsCount() {
        return manualTicketsCount;
    }
}
