package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static int money;
    public static ArrayList<Lotto> allLotto = new ArrayList<>();
    public static String winNumInput;
    public static WinNum winNum;
    public static void main(String[] args) {
        inputMoney();
        makeLottoNum();
        inputWinNum();
    }

    static void inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        money = sc.nextInt();
        sc.nextLine();
        System.out.println(money/1000 + "개를 구매했습니다.");
    }
    static void makeLottoNum() {
        for(int i=0;i<money/1000;i++) {
            allLotto.add(new Lotto());
        }
        for(int i=0;i<allLotto.size();i++) {
            allLotto.get(i).showLotto();
        }
        System.out.println();
    }
    static void inputWinNum() {
        System.out.println("당첨 번호를 입력해 주세요.");
        winNumInput = sc.nextLine();
        winNum = new WinNum(winNumInput);
    }
}