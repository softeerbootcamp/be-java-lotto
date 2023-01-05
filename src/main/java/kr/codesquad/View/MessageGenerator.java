package kr.codesquad.View;

import kr.codesquad.Model.Price;
import kr.codesquad.Model.WinnerCalculator;

public class MessageGenerator {
<<<<<<< HEAD
    private static final String headerMsg = "당첨 통계\n---------";
    private static final String winRequestMsg = "당첨 번호를 입력해 주세요.";
    private static final String earnMsg = "총 수익률은 .2f%%입니다.";
    private static final String bonusPostfix = ", 보너스 볼 일치";
    private static final String moneyReqMsg = "구입금액을 입력해 주세요.";
    private static final String sameMsg = "%d개 일치";
    private static final String moneyMsg = "(%d원) - %d개";
    private static final String buyMsg = "%d개를 구매했습니다.";
    private static final String bonusReqMsg = "보너스 볼을 입력해 주세요.";
    public String getResultMsg(WinnerCalculator winnerCalculator){
        String rtnMsg = "";
        for (Price price:Price.values()){
            rtnMsg += String.format(sameMsg,price.getCountOfMatch());
            rtnMsg += getBonusPostfix(price);
            rtnMsg += String.format(moneyMsg,(int)price.getWinningMoney(),winnerCalculator.winnerCount.get(price))+"\n";
=======
    public static final String headerMsg = "당첨 통계\n---------";
    public static final String winRequestMsg = "당첨 번호를 입력해 주세요.";
    public static final String earnMsg = "총 수익률은 .2f%%입니다.";
    public static final String bonusPostfix = ", 보너스 볼 일치";
    public static final String moneyReqMsg = "구입금액을 입력해 주세요.";
    public static final String sameMsg = "%d개 일치";
    public static final String moneyMsg = "(%d원) - %d개";
    public static final String buyMsg = "%d개를 구매했습니다.";
    public static final String bonusReqMsg = "보너스 볼을 입력해 주세요.";

    public String getResultMsg(WinnerCalculator winnerCalculator) {
        String rtnMsg = "";
        Price[] prices = Price.values();

        for(int i = 0; i < prices.length; ++i) {
            Price price = prices[i];
            rtnMsg = rtnMsg + String.format(sameMsg, price.getCountOfMatch());
            rtnMsg = rtnMsg + this.getBonusPostfix(price);
            rtnMsg = rtnMsg + String.format(moneyMsg, (int)price.getWinningMoney(), winnerCalculator.winnerCount.get(price)) + "\n";
>>>>>>> cbaed76 (변수명 변경 및 코드 정리)
        }
        return rtnMsg;
    }

<<<<<<< HEAD
    public String getBonusReqMsg(){
        return bonusReqMsg;
    }
    public String getMoneyReqMsg(){
        return moneyReqMsg;
    }
    public String getBuyMsg(int num){
        return String.format(buyMsg, num);
    }
    public String getHeaderMsg(){
        return headerMsg;
    }

    public String getWinRequestMsg(){
        return winRequestMsg;
    }

    public String getEarnMsg(){
        return earnMsg;
    }

    private String getBonusPostfix(Price price){
        return price == Price.BONUS?bonusPostfix:"";
=======
    public String getBuyMsg(int num) {
        return String.format(buyMsg, num);
    }

    public String getEarnMsg(double earn) {
        return String.format(earnMsg,earn);
    }

    private String getBonusPostfix(Price price) {
        return price == Price.BONUS ? bonusPostfix : "";
>>>>>>> cbaed76 (변수명 변경 및 코드 정리)
    }
}
