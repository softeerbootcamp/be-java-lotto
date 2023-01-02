package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<List<Integer>> lottoList = new ArrayList<>();
    static List<Integer> winNumList;

    public static void main(String[] args) {
        int count = getLottoCount();
        System.out.println(count + "개를 구매했습니다.");

        shuffle(count);
        inputWinNum();
    }

    public static int getLottoCount() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt() / 1000;
    }

    public static void shuffle(int count) {
        List<Integer> numList = new ArrayList<>();
        for(int i = 1;i <= 45;i++) numList.add(i);

        for(int i = 0;i < count;i++) {
            Collections.shuffle(numList);
            lottoList.add(numList.subList(0, 6));
            Collections.sort(lottoList.get(i));
            System.out.println(lottoList.get(i).toString());
        }
    }

    public static void inputWinNum() {
        Scanner sc = new Scanner(System.in);
        System.out.println("당첨 번호를 입력해 주세요.");
        String winNum = sc.nextLine();
        String[] temp = winNum.split(",");

        winNumList = new ArrayList<>();
        for(int i = 0;i < 6;i++) winNumList.add(Integer.parseInt(temp[i]));
    }
}