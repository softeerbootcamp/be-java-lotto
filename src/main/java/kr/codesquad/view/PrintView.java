package kr.codesquad.view;

import kr.codesquad.util.CommonMessage;

public class PrintView {

    public static void enterPurchaseAmount() {
        System.out.println(CommonMessage.ENTER_PURCHASE_AMOUNT);
    }

    public static void resultPurchaseAmount(int purchaseTicket) {
        System.out.println(purchaseTicket + CommonMessage.PURCHASE_TICKETS);
    }

}
