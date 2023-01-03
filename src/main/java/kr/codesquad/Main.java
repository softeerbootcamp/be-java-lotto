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

        for(int i = 0;i < count;i++) {
            int winCount = countWin(i);
        }
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
            List<Integer> subList = new ArrayList<>(numList.subList(0, 6));
            lottoList.add(subList);
            Collections.sort(lottoList.get(i));
            System.out.println(lottoList.get(i));
        }
    }

    public static void inputWinNum() {
        Scanner sc = new Scanner(System.in);
        System.out.println("당첨 번호를 입력해 주세요.");
        String winNum = sc.nextLine();
        String[] temp = winNum.split(", ");

        winNumList = new ArrayList<>();
        for(int i = 0;i < 6;i++) winNumList.add(Integer.parseInt(temp[i]));
    }

    public static int countWin(int index) {
        int winCount = 0;

        if(lottoList.get(index).contains(winNumList.get(0))) winCount++;
        if(lottoList.get(index).contains(winNumList.get(1))) winCount++;
        if(lottoList.get(index).contains(winNumList.get(2))) winCount++;
        if(lottoList.get(index).contains(winNumList.get(3))) winCount++;
        if(lottoList.get(index).contains(winNumList.get(4))) winCount++;
        if(lottoList.get(index).contains(winNumList.get(5))) winCount++;

        return winCount;
    }
}