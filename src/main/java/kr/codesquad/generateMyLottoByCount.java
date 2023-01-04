package kr.codesquad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class generateMyLottoByCount {
    private List<EmptyLotto> lottoList;

    public List<EmptyLotto> getLottoList() {
        return this.lottoList;
    }

    public void generateAuto(int lotto_cnt) {
        lottoList = new ArrayList<>(lotto_cnt);
        Utility ut = new Utility();
        for (int j = 0; j < lotto_cnt; j++) {
            EmptyLotto emptyLotto = new EmptyLotto(ut.retRandLottoNum());
            lottoList.add(emptyLotto);
            emptyLotto.printNumbers();
        }
    }
    public void generateMyself(int lotto_cnt){
        System.out.printf("수동으로 구매할 번호를 입력해 주세요");
        Utility ut = new Utility();
        Scanner s2 = new Scanner(System.in);
        List<Integer> myselfNumber = new ArrayList<>();
        for (int i=0;i<lotto_cnt;i++){
            String str = s2.nextLine();
            ut.transStringToIntegerList(str);


        }

    }
}
