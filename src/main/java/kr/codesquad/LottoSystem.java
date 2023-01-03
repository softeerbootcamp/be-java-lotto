package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LottoSystem {
    private final List<Integer> numList;

    public LottoSystem() {
        this.numList = new ArrayList<>();
        for(int i = 1;i <= 45;i++) this.numList.add(i);
    }

    public Lotto buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt() / 1000;
        System.out.println(count + "개를 구매했습니다.");

        return new Lotto(shuffle(count));
    }

    public List<List<Integer>> shuffle(int count) {
        List<List<Integer>> lottoList = new ArrayList<>();

        for(int i = 0;i < count;i++) {
            Collections.shuffle(numList);
            List<Integer> subList = new ArrayList<>(numList.subList(0, 6));

            lottoList.add(subList);
            Collections.sort(lottoList.get(i));
            System.out.println(lottoList.get(i));
        }

        return lottoList;
    }
}
