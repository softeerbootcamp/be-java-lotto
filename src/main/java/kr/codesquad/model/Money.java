package kr.codesquad.model;

import kr.codesquad.model.lotto.Lotto;
import kr.codesquad.util.error.MoneyErrorMessage;

public class Money {
    private final int purchaseMoney;

    public Money(int purchaseMoney) {
        valid(purchaseMoney);
        this.purchaseMoney = purchaseMoney;
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }

    private void valid(int purchaseMoney) throws IllegalArgumentException {
        if (!isOverTicketPerPrice(purchaseMoney)) {
            throw new IllegalArgumentException(MoneyErrorMessage.NOT_OVER_TICKET_PER_PRICE);
        }
        if (!isDivideTicketPerPrice(purchaseMoney)) {
            throw new IllegalArgumentException(MoneyErrorMessage.NOT_DIVIDE_TICKET_PER_PRICE);
        }
    }

    private boolean isOverTicketPerPrice(int purchaseMoney) {
        return purchaseMoney >= Lotto.TICKET_PER_PRICE;
    }

    private boolean isDivideTicketPerPrice(int purchaseMoney) {
        return purchaseMoney % Lotto.TICKET_PER_PRICE == 0;
    }
}
