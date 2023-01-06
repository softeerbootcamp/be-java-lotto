package kr.codesquad.controller;

import kr.codesquad.model.*;
import kr.codesquad.model.lotto.ManualLotto;
import kr.codesquad.model.lotto.WinningLotto;
import kr.codesquad.view.PrintView;
import kr.codesquad.view.ReceiveView;

import java.util.List;

public class LottoController {


    public void play() {
        User user = purchaseLotto();

        //수동구매 입력받은 후 user객제체에 로또번호 업데이트
        enterManualLottoNumbers(user);

        printBuyLotto(user);
        WinningLotto winningLotto = getWinningLotto();
        computeResult(user, winningLotto);
        PrintView.resultStatic(user);
    }

    private void printBuyLotto(User user) {
        Ticket userTicket = user.getTicket();
        PrintView.resultPurchaseAmount(userTicket.getManualTicketsCount(), userTicket.getAutoTicketsCount());
        PrintView.generatedLottos(user);
    }

    private void enterManualLottoNumbers(User user) {
        PrintView.enterManualLottos();
        for (int count = 0; count < user.getTicket().getManualTicketsCount(); count++) {
            List<Integer> manualLotto = ReceiveView.enterManualLottos();
            user.insertManualLotto(new ManualLotto(manualLotto));
        }
    }

    private void computeResult(User user, WinningLotto winningLotto) {
        ResultStatistic.computeResult(user, winningLotto);
        double profit = ResultStatistic.computeProfit(user);
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
        int bonusBall = ReceiveView.enterInt();
        return bonusBall;
    }

    private List<Integer> getSixWinningNumbers() {
        PrintView.enterWinningNumber();
        List<Integer> winningNumbers = ReceiveView.enterManualLottos();
        return winningNumbers;
    }

    private User purchaseLotto() {
        Money money = new Money(enterPurchaseAmount());
        Ticket ticket = makeTicket(money);
        User user = new User(money,ticket);
        return user;
    }

    private Ticket makeTicket(Money money) {
        int manualTicketsCount = purchaseManualTickets();
        int autoTicketsCount = Ticket.purchaseAutoTickets(money, manualTicketsCount);
        return new Ticket(manualTicketsCount,autoTicketsCount);
    }

    private  int purchaseManualTickets() {
        PrintView.enterManualTickets();
        return ReceiveView.enterManualTickets();
    }

    private int enterPurchaseAmount() {
        PrintView.enterPurchaseAmount();
        return ReceiveView.enterInt();
    }
}
