package kr.codesquad.View;

import kr.codesquad.Model.LottoService;
import kr.codesquad.Model.Price;

import java.math.RoundingMode;

public class LottoPrinter {
    static final String header = "\n당첨 통계\n---------";
    public void printResult(LottoService lottoService){
        printHeader();
        for (Price price:Price.values()){
            System.out.print(price.getCountOfMatch()+"개 일치");
            bonusPrint(price);
            System.out.println(" ("+(int)price.getWinningMoney()+")- "+lottoService.winnerCount.get(price)+"개");
        }
        System.out.println("총 수익률은 "+lottoService.earn.setScale(2, RoundingMode.FLOOR)+"%입니다.");
    }

    private void printHeader(){
        System.out.println(header);
    }
    private void bonusPrint(Price price){
        if (price == Price.BONUS)
            System.out.print(", 보너스 볼 일치");
    }

    public void printBuy(int lotto_amount) {
        System.out.println(lotto_amount+"개를 구매했습니다.");
    }

    public void printWinRequest(){
        System.out.println("\n당첨 번호를 입력해 주세요.");    //, 처리 필요 -> string 활용
    }
}
