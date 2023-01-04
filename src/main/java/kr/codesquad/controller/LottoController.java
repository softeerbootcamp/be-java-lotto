package kr.codesquad.controller;

import kr.codesquad.model.lotto.Lotto;
import kr.codesquad.model.User;
import kr.codesquad.model.lotto.ManualLotto;
import kr.codesquad.model.lotto.WinningLotto;
import kr.codesquad.model.WinningStatic;
import kr.codesquad.view.PrintView;
import kr.codesquad.view.ReceiveView;

import java.util.List;

public class LottoController {


    public void play() {
        User user = getUserWithPurchase();

        //수동구매 입력받은 후 user객체에 로또번호 업데이트
        updateManualLottos(user);

        printBuyLotto(user);
        WinningLotto winningLotto = getWinningLotto();
        computeResult(user, winningLotto);
        PrintView.resultStatic(user);
    }

    private void printBuyLotto(User user) {
        PrintView.resultPurchaseAmount(user.getManualTicketsCount(), user.getAutoTicketsCount());
        PrintView.generatedLottos(user);
    }

    private void updateManualLottos(User user) {
        PrintView.enterManualLottos();
        for (int count = 0; count < user.getManualTicketsCount(); count++) {
            List<Integer> manualLotto = ReceiveView.enterManualLottos();
            user.insertLotto(new ManualLotto(manualLotto));
        }
    }

    private void computeResult(User user, WinningLotto winningLotto) {
        WinningStatic.computeResult(user, winningLotto);
        double profit = WinningStatic.computeProfit(user);
        user.getWinningStatic().updateProfit(profit);
    }

    private WinningLotto getWinningLotto() {
        List<Integer> winningNumbers = getSixWinningNumbers();
        int bonusBall = getBonusBall();

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusBall);
        return winningLotto;
    }

    private int getBonusBall() {
        PrintView.enterBonusBall();
        int bonusBall = ReceiveView.enterBonusBall();
        return bonusBall;
    }

    private List<Integer> getSixWinningNumbers() {
        PrintView.enterWinningNumber();
        List<Integer> winningNumbers = ReceiveView.enterManualLottos();
        return winningNumbers;
    }

    private User getUserWithPurchase() {
        int purchaseAmount = enterPurchaseAmount();
        int manualTicketsCount = purchaseManualTickets();
        int autoTicketsCount = purchaseAutoTickets(purchaseAmount,manualTicketsCount);
        User user = makeUser(purchaseAmount, manualTicketsCount, autoTicketsCount);
        return user;
    }

    private  int purchaseManualTickets() {
        PrintView.enterManualTickets();
        return ReceiveView.enterManualTickets();
    }

    private User makeUser(int purchaseAmount, int manualTicketsCount, int autoTicketsCount) {
        //User 생성자에서 자동으로 구입티켓 개수를 기반으로 로또번호 생성받음
        return new User(purchaseAmount, manualTicketsCount, autoTicketsCount);
    }

    private int purchaseAutoTickets(int purchaseAmount, int manualTickets) {
        int change = purchaseAmount - manualTickets * Lotto.TICKET_PER_PRICE;
        int autoTickets = change / Lotto.TICKET_PER_PRICE;
        return autoTickets;
    }

    private int enterPurchaseAmount() {
        PrintView.enterPurchaseAmount();
        return ReceiveView.enterPurchaseAmount();
    }
}
