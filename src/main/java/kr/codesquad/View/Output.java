package kr.codesquad.View;

import kr.codesquad.Model.Lotto;
import kr.codesquad.Model.LottoGame;
import kr.codesquad.Model.LottoResult;
import kr.codesquad.Model.Rank;

import java.util.List;

public class Output {

    public static void printCount(int count){
        // 구입 개수 출력
        System.out.println(count + "개를 구매했습니다.");
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

    public static void printRate(int price, int totalWinPrice){
        // 수익률 계산 = 딴 돈 / 낸 돈  백분율
        double winRate = (double)totalWinPrice / price * 100;
        // 손해일 경우 - 100
        // 기존의 30퍼센트 = -70퍼센트
        if(totalWinPrice < price) winRate -= 100.0;
        System.out.println("총 수익률은 " + String.format("%.2f",winRate) + "%입니다.");
    }
}
