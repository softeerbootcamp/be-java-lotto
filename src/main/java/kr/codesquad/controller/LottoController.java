package kr.codesquad.controller;

import kr.codesquad.view.PrintView;
import kr.codesquad.view.ReceiveView;

public class LottoController {
    public static final int TICKET_PER_PRICE = 1000;

    public void play() {
        int purchaseAmount = enterPurchaseAmount();
        int purchaseTickets = purchaseToTickets(purchaseAmount);

    }

    private static int purchaseToTickets(int purchaseAmount) {
        int purchaseTickets = purchaseAmount / TICKET_PER_PRICE;
        PrintView.resultPurchaseAmount(purchaseTickets);
        return purchaseTickets;
    }

    private static int enterPurchaseAmount() {
        PrintView.enterPurchaseAmount();
        return ReceiveView.EnterPurchaseAmount();
    }
}
