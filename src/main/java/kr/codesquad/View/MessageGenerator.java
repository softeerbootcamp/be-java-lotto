package kr.codesquad.View;

import kr.codesquad.Model.Price;
import kr.codesquad.Model.User;
import kr.codesquad.Model.WinnerCalculator;

public class MessageGenerator {
    public static final String headerMsg = "당첨 통계\n---------";
    public static final String winRequestMsg = "당첨 번호를 입력해 주세요.";
    public static final String earnMsg = "총 수익률은 %.2f%%입니다.";
    public static final String bonusPostfix = ", 보너스 볼 일치";
    public static final String moneyReqMsg = "구입금액을 입력해 주세요.";
    public static final String sameMsg = "%d개 일치";
    public static final String moneyMsg = "(%d원) - %d개";
    public static final String buyMsg = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    public static final String bonusReqMsg = "보너스 볼을 입력해 주세요.";
    public static final String manualAmountReqMsg = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String manualNumberReqMsg = "수동으로 구매할 번호를 입력해 주세요.";

    public String getResultMsg(WinnerCalculator winnerCalculator, User user) {
        String rtnMsg = headerMsg+'\n';
        Price[] prices = Price.values();
        for(int i = 0; i < prices.length; ++i) {
            Price price = prices[i];
            rtnMsg += String.format(sameMsg, price.getCountOfMatch());
            rtnMsg += this.getBonusPostfix(price);
            rtnMsg += String.format(moneyMsg, (int)price.getWinningMoney(), winnerCalculator.winnerCount.get(price)) + "\n";
        }
        rtnMsg += String.format(earnMsg,user.earn.doubleValue());
        return rtnMsg;
    }

    public String getBuyMsg(int manualCount, int autoCount) {
        return String.format(buyMsg, manualCount, autoCount);
    }

    public String getEarnMsg(double earn) {
        return String.format(earnMsg,earn);
    }

    private String getBonusPostfix(Price price) {
        return price == Price.BONUS ? bonusPostfix : "";
    }
}
