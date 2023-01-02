package kr.codesquad;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class LottoSystem {
    int money;
    int[] winNums;
    Scanner sc;
    ArrayList<Lotto> lottos;
    int[] result = new int[7];
    double rate;

    public void getMoney() {
        System.out.println("구입금액을 입력해주세요.");
        sc = new Scanner(System.in);
        money = Integer.parseInt(sc.nextLine());
        System.out.println(money / 1000 + "개를 구매했습니다.");

    }

    public void getLottos() {
        lottos = new ArrayList<Lotto>();
        for (int i = 0; i < money / 1000; i++) {
            Lotto l = new Lotto();
            lottos.add(l);
            l.printLotto();
        }
    }

    public void getWin() {
        sc = new Scanner(System.in);
        System.out.println("\n당첨 번호를 입력해주세요.");
        String[] s = sc.nextLine().replaceAll(" ", "").split(",");
        winNums = Stream.of(s).mapToInt(Integer::parseInt).toArray();
        //win = new Lotto(temp);
    }

    public void getResult() {
        for (int i = 0; i < money / 1000; i++) {
            int cnt = lottos.get(i).checkWin(winNums);
            result[cnt]++;
        }
        long earnMoney = 5000l * result[3] + 50000l * result[4] + 1500000l * result[5] + 2000000000l * result[6];
        rate = (earnMoney - money) / (double) money * 100;
    }

    public void printResult() {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (5000원)- %d개\n", result[3]);
        System.out.printf("4개 일치 (50000원)- %d개\n", result[4]);
        System.out.printf("5개 일치 (1500000원)- %d개\n", result[5]);
        System.out.printf("6개 일치 (2000000000원)- %d개\n", result[6]);
        System.out.printf("총 수익률은 %.2f%%입니다.\n", rate);
    }
}