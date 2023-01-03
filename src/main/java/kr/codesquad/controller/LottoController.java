package kr.codesquad.controller;

import kr.codesquad.model.Result;
import kr.codesquad.model.User;
import kr.codesquad.model.WinningLotto;
import kr.codesquad.model.WinningStatic;
import kr.codesquad.view.PrintView;
import kr.codesquad.view.ReceiveView;

import java.util.List;

public class LottoController {
    public static final int TICKET_PER_PRICE = 1000;

    public void play() {
        User user = getUserWithPurchase();
        PrintView.generatedLottos(user);

        WinningLotto winningLotto = getWinningLotto();

        computeResult(user, winningLotto);

        PrintView.resultStatic(user);
    }

    private static void computeResult(User user, WinningLotto winningLotto) {
        WinningStatic.computeResult(user, winningLotto);
        double profit = WinningStatic.computeProfit(user);
        user.getWinningStatic().updateProfit(profit);
    }

    private static WinningLotto getWinningLotto() {
        PrintView.enterWinningNumber();
        List<Integer> winningNumbers = ReceiveView.enterWinningNumbers();
        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        return winningLotto;
    }

    private User getUserWithPurchase() {
        int purchaseAmount = enterPurchaseAmount();
        int purchaseTickets = purchaseToTickets(purchaseAmount);
        User user = makeUser(purchaseAmount, purchaseTickets);
        return user;
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
