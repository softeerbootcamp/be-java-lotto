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

        for(int i = 0; i < lottoCount; i++) {
            int winNumCount = countWinNum(lotto, winNumList, i);
        }
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
}
