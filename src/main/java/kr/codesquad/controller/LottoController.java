package kr.codesquad.controller;

import kr.codesquad.model.User;
import kr.codesquad.model.WinningLotto;
import kr.codesquad.view.PrintView;
import kr.codesquad.view.ReceiveView;

import java.util.List;

public class LottoController {
    public static final int TICKET_PER_PRICE = 1000;

    public void play() {
        int purchaseAmount = enterPurchaseAmount();
        int purchaseTickets = purchaseToTickets(purchaseAmount);
        User user = makeUser(purchaseAmount, purchaseTickets);
        PrintView.generatedLottos(user);
        PrintView.enterWinningNumber();

        List<Integer> winningNumbers = ReceiveView.enterWinningNumbers();
        WinningLotto winningLotto = new WinningLotto(winningNumbers);

    }

    private User makeUser(int purchaseAmount, int purchaseTickets) {
        //User 생성자에서 자동으로 구입티켓 개수를 기반으로 로또번호 생성받음
        return new User(purchaseAmount, purchaseTickets);
    }

    private static int purchaseToTickets(int purchaseAmount) {
        int purchaseTickets = purchaseAmount / TICKET_PER_PRICE;
        PrintView.resultPurchaseAmount(purchaseTickets);
        return purchaseTickets;
    }

    private static int enterPurchaseAmount() {
        PrintView.enterPurchaseAmount();
        return ReceiveView.enterPurchaseAmount();
    }
}
