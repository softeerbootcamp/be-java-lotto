package kr.codesquad.view;

import kr.codesquad.model.Lotto;
import kr.codesquad.model.Result;
import kr.codesquad.model.User;
import kr.codesquad.util.CommonMessage;

import java.util.HashMap;

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

    public static void enterWinningNumber() {
        System.out.println(CommonMessage.ENTER_WINNING_NUMBER);
    }

    public static void resultStatic(User user) {
        System.out.println(CommonMessage.RESULT_STATIC);
        System.out.println(CommonMessage.HYPHEN);

        resultWinningStatic(user);
        resultProfit(user);
    }

    private static void resultProfit(User user) {
        String profit = String.format("%.1f", user.getProfit());
        System.out.println("총 수익률은 "+profit+"%입니다.");
    }

    private static void resultWinningStatic(User user) {
        HashMap<Result, Integer> resultMatch = user.getResultMatch();
        for (Result result : Result.notIncludeNotMatch()) {
            System.out.printf("%d개 일치: (%d원)",result.getMatchCount(),result.getReward());
            System.out.printf("- %d개\n", resultMatch.get(result));
        }
    }

}
