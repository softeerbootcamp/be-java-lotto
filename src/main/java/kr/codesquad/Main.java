package kr.codesquad;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        int price = sc.nextInt();
        int count = price/1000;
        System.out.println(count + "개를 구매했습니다.");

        // 로또 클래스 생성
        Lotto lotto = new Lotto();

        // count 만큼의 로또 번호 생성
        lotto.createLottoNumber(count);

        // 출력
        lotto.printLottoBuyList();

        // 입력 버퍼 비우기
        sc.nextLine();

        System.out.println("\n당첨 번호를 입력해 주세요");
        String[] winLottoNumString = sc.nextLine().split(", ");
        // 당첨 번호 저장
        lotto.setWinLottoNum(winLottoNumString);

        // 당첨 통계
        System.out.println("\n당첨 통계\n----------");

        // 맞춘 개수(통계) 구하기
        lotto.statistics();

        lotto.printScore();
        lotto.printRate(price);


    }
}