package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int money = sc.nextInt();
        System.out.println(money/1000 + "개를 구매했습니다.");
        ArrayList<Lotto> allLotto = new ArrayList<>();
        for(int i=0;i<money/1000;i++) {
            allLotto.add(new Lotto());
        }
        for(int i=0;i<allLotto.size();i++) {
            allLotto.get(i).showLotto();
        }


    }
}