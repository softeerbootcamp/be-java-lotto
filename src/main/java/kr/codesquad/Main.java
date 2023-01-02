package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<List<Integer>> lottoList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt() / 1000;
        System.out.println(count + "개를 구매했습니다.");

        shuffle(count);
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
}