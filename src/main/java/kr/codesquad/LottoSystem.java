package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LottoSystem {
    private final List<Integer> numList;

    private static int lottoCount;

    public LottoSystem() {
        this.numList = new ArrayList<>();
        for(int i = 1;i <= 45;i++) this.numList.add(i);
    }

    public Lotto buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        lottoCount = sc.nextInt() / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");

        return new Lotto(shuffle(lottoCount));
    }

    public List<List<Integer>> shuffle(int lottoCount) {
        List<List<Integer>> lottoList = new ArrayList<>();

        for(int i = 0;i < lottoCount;i++) {
            Collections.shuffle(numList);
            List<Integer> subList = new ArrayList<>(numList.subList(0, 6));

            lottoList.add(subList);
            Collections.sort(lottoList.get(i));
            System.out.println(lottoList.get(i));
        }

        return lottoList;
    }

    public void checkLotto(Lotto lotto) {
        System.out.println("당첨 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String winNum = sc.nextLine();
        String[] temp = winNum.split(", ");

        List<Integer> winNumList = new ArrayList<>();
        for(int i = 0;i < 6;i++) winNumList.add(Integer.parseInt(temp[i]));

        List<Integer> result = new ArrayList<>(List.of(0, 0, 0, 0));
        for(int i = 0; i < lottoCount; i++) {
            int winNumCount = countWinNum(lotto, winNumList, i);
            setResult(result, winNumCount);
        }

        printResult(result);
    }

    public int countWinNum(Lotto lotto, List<Integer> winNumList, int index) {
        List<List<Integer>> lottoList = lotto.getLottoList();
        int winNumCount = 0;

        if(lottoList.get(index).contains(winNumList.get(0))) winNumCount++;
        if(lottoList.get(index).contains(winNumList.get(1))) winNumCount++;
        if(lottoList.get(index).contains(winNumList.get(2))) winNumCount++;
        if(lottoList.get(index).contains(winNumList.get(3))) winNumCount++;
        if(lottoList.get(index).contains(winNumList.get(4))) winNumCount++;
        if(lottoList.get(index).contains(winNumList.get(5))) winNumCount++;

        return winNumCount;
    }

    public void setResult(List<Integer> result, int winNumCount) {
        if(winNumCount == 3) result.set(0, result.get(0) + 1);
        if(winNumCount == 4) result.set(1, result.get(1) + 1);
        if(winNumCount == 5) result.set(2, result.get(2) + 1);
        if(winNumCount == 6) result.set(3, result.get(3) + 1);
    }

    public void printResult(List<Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println("3개 일치 (5000원)- " + result.get(0) + "개");
        System.out.println("4개 일치 (50000원)- " + result.get(1) + "개");
        System.out.println("5개 일치 (1500000원)- " + result.get(2) + "개");
        System.out.println("6개 일치 (2000000000원)- " + result.get(3) + "개");

        List<Integer> price = List.of(5000, 50000, 1500000, 2000000000);
        long resultPrice = (long) result.get(0) * price.get(0) + (long) result.get(1) * price.get(1) +
                (long) result.get(2) * price.get(2) + (long) result.get(3) * price.get(3);
        long expense = lottoCount * 1000L;
        System.out.println("총 수익률은 " + (resultPrice - expense) / expense + "%입니다.");
    }
}
