package kr.codesquad.View;

import kr.codesquad.Model.LottoService;
import kr.codesquad.Model.Price;

import java.math.RoundingMode;

public class MessageGenerator {
    private static final String headerMsg = "당첨 통계\n---------";
    private static final String winRequestMsg = "당첨 번호를 입력해 주세요.";
    private static final String earnMsg = "총 수익률은 .2f%%입니다.";
    private static final String bonusPostfix = ", 보너스 볼 일치";
    private static final String moneyReqMsg = "구입금액을 입력해 주세요.";
    private static final String sameMsg = "%d개 일치";
    private static final String moneyMsg = "(%d원)-";
    private static final String buyMsg = "%d개를 구매했습니다.";

    public void getResultMsg(LottoService lottoService){
        for (Price price:Price.values()){
            System.out.print(price.getCountOfMatch()+"개 일치");
            bonusPrint(price);
            System.out.println(" ("+(int)price.getWinningMoney()+")- "+lottoService.winnerCount.get(price)+"개");
        }
        System.out.println();
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

    private void bonusPrint(Price price){
        if (price == Price.BONUS)
            System.out.print(", 보너스 볼 일치");
    }
}
