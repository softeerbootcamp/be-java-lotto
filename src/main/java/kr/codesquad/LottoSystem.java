package kr.codesquad;

import java.util.ArrayList;
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
    }
}
