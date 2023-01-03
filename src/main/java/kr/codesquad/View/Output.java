package kr.codesquad.View;

import kr.codesquad.Model.Lotto;

import java.util.List;

public class Output {

    public static void printCount(int count){
        // 구입 개수 출력
        System.out.println(count + "개를 구매했습니다.");
    }


    public static void printLottoBuyList(List<Lotto> lottoBuyList) {
        for (Lotto lottoBuy : lottoBuyList) {
            // 출력
            printLottoNumbers(lottoBuy);
        }
    }

    public static void printLottoNumbers(Lotto lotto){
        System.out.println(lotto.getLottoNumbers());
    }
}
