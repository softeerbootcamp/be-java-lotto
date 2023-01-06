package kr.codesquad.View;

import kr.codesquad.Model.*;

import java.util.List;

public class Output {

    public static void printGetPrice(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printGetLastWinLottoNum(){
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요");
    }

    public static void printCount(int manualLottoCount, int autoLottocount){
        // 구입 개수 출력
        System.out.println("\n수동으로 " + manualLottoCount + "장, 자동으로 " + autoLottocount + "개를 구매했습니다.");
    }

    public static void printGetManuelLottoCount(){
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public static void printGetManuelLottoNum(){
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
    }

    public static void printGetBonusBall(){
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public static void printLottoBuyList(LottoGame lottoGame) {
        for (Lotto lottoBuy : lottoGame.getLottoBuyList()) {
            // 출력
            printLottoNumbers(lottoBuy);
        }
    }

    public static void printLottoNumbers(Lotto lotto){
        System.out.println(lotto.toListInteger());
    }

    public static void printScore(LottoResult lottoResult) {
        System.out.println("\n당첨 통계\n----------");
        System.out.println("3개 일치 (" + Rank.FIFTH.getWinningMoney() + "원) - " + lottoResult.getValue(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (" + Rank.FOURTH.getWinningMoney() + "원) - " + lottoResult.getValue(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (" + Rank.THIRD.getWinningMoney() + "원) - " + lottoResult.getValue(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(" + Rank.SECOND.getWinningMoney() + "원) - " + lottoResult.getValue(Rank.SECOND) + "개");
        System.out.println("6개 일치 (" + Rank.FIRST.getWinningMoney() + "원) - " + lottoResult.getValue(Rank.FIRST) + "개");
    }

    public static void printRate(LottoResult lottoResult, Money money){
        System.out.println("구입 금액은 " + money.toString() + "원이고, 총 당첨금은 " + lottoResult.getPrize().toString() + "원입니다.");
        System.out.println("총 수익률은 " + String.format("%.2f", money.profitRate(lottoResult.getPrize())) + "%입니다.");
    }
}
