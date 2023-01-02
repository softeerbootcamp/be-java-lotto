package main.java.kr.codesquad;

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        System.out.println("구입 금액을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);

        int money = scanner.nextInt();
        int count = money / 1000;

        System.out.println(count + "개를 구매했습니다.");

        lotto.makeLottoList(count);
        lotto.printLottoList(count);

        System.out.println("당첨 번호를 입력해주세요");

        Scanner sc2 = new Scanner(System.in);
        
        String jackPotString = sc2.nextLine();
        lotto.getJackPotNumbers(jackPotString);

        System.out.println("당첨 통계");
        System.out.println("----------");

        lotto.checkJackPots();
    }
}