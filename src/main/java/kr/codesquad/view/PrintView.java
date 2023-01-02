package kr.codesquad.view;

import kr.codesquad.model.Lotto;
import kr.codesquad.model.User;
import kr.codesquad.util.CommonMessage;

public class PrintView {

    public static void enterPurchaseAmount() {
        System.out.println(CommonMessage.ENTER_PURCHASE_AMOUNT);
    }

    public static void resultPurchaseAmount(int purchaseTicket) {
        System.out.println(purchaseTicket + CommonMessage.PURCHASE_TICKETS);
    }

    public static void generatedLottos(User user) {
        for (Lotto lotto : user.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

}
