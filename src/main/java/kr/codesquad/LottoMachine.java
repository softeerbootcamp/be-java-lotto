package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private final int lottoPrice; // 로또 하나의 가격 정보
    private final List<Integer> numList;

    public LottoMachine(int lottoPrice) {
        this.lottoPrice = lottoPrice;
        this.numList = new ArrayList<>();
        for(int i = 1;i <= 45;i++) this.numList.add(i);
    }

    public Lotto buyLotto() {
        UserInput ui = new UserInput();
        int money = ui.inputMoney();
        int lottoCount = money / this.lottoPrice;
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
}
