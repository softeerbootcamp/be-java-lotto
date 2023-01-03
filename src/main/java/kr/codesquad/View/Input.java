package kr.codesquad.View;

import kr.codesquad.Model.Lotto;

import java.util.Scanner;

public class Input {
    static Scanner sc = new Scanner(System.in);
    public static int inputPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        return sc.nextInt();
    }

    public static Lotto inputWinLottoNum() {
        Lotto winLottoNum = new Lotto();
        // 당첨 번호 입력 받기
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요");
        String[] winLottoNumString = sc.nextLine().split(", ");
        for(int i = 0;i<6;i++){
            winLottoNum.addLottoNum(Integer.parseInt(winLottoNumString[i]));
        }
        return winLottoNum;
    }

    public static int inputBonusBall(){
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }
}
