//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package kr.codesquad.View;

import kr.codesquad.Model.Price;
import kr.codesquad.Model.WinnerCalculator;

public class MessageGenerator {
    private static final String headerMsg = "당첨 통계\n---------";
    private static final String winRequestMsg = "당첨 번호를 입력해 주세요.";
    private static final String earnMsg = "총 수익률은 .2f%%입니다.";
    private static final String bonusPostfix = ", 보너스 볼 일치";
    private static final String moneyReqMsg = "구입금액을 입력해 주세요.";
    private static final String sameMsg = "%d개 일치";
    private static final String moneyMsg = "(%d원) - %d개";
    private static final String buyMsg = "%d개를 구매했습니다.";
    private static final String bonusReqMsg = "보너스 볼을 입력해 주세요.";

    public MessageGenerator() {
    }

    public String getResultMsg(WinnerCalculator winnerCalculator) {
        String rtnMsg = "";
        Price[] var3 = Price.values();
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Price price = var3[var5];
            rtnMsg = rtnMsg + String.format("%d개 일치", price.getCountOfMatch());
            rtnMsg = rtnMsg + this.getBonusPostfix(price);
            rtnMsg = rtnMsg + String.format("(%d원) - %d개", (int)price.getWinningMoney(), winnerCalculator.winnerCount.get(price)) + "\n";
        }

        return rtnMsg;
    }

    public String getBonusReqMsg() {
        return "보너스 볼을 입력해 주세요.";
    }

    public String getMoneyReqMsg() {
        return "구입금액을 입력해 주세요.";
    }

    public String getBuyMsg(int num) {
        return String.format("%d개를 구매했습니다.", num);
    }

    public String getHeaderMsg() {
        return "당첨 통계\n---------";
    }

    public String getWinRequestMsg() {
        return "당첨 번호를 입력해 주세요.";
    }

    public String getEarnMsg() {
        return "총 수익률은 .2f%%입니다.";
    }

    private String getBonusPostfix(Price price) {
        return price == Price.BONUS ? ", 보너스 볼 일치" : "";
    }
}
