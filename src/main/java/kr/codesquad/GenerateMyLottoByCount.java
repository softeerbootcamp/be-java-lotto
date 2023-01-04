package kr.codesquad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateMyLottoByCount {
    private List<EmptyLotto> lottoList;
    private int lottoCounts;
    private int mySelfLottoCounts;
    public GenerateMyLottoByCount(int lotto_cnt) {
        lottoList = new ArrayList<>(lotto_cnt);
        this.lottoCounts = lotto_cnt;
    }

    public List<EmptyLotto> getLottoList() {
        return this.lottoList;
    }

    public void generateAuto() {
        Utility ut = new Utility();
        for (int j = 0; j < this.lottoCounts-this.mySelfLottoCounts; j++) {
            EmptyLotto emptyLotto = new EmptyLotto(ut.retRandLottoNum());
            lottoList.add(emptyLotto);
            emptyLotto.printNumbers();
        }
    }
    public void generateMyself() throws CustomException {
        InputHandler inputHandler = new InputHandler();
        System.out.printf("수동으로 구매할 로또 수를 입력해 주세요\n");
//        Scanner s1 = new Scanner(System.in);
        this.mySelfLottoCounts= inputHandler.getIntegerInput();
        if(mySelfLottoCounts > lottoCounts){
            throw new CustomException("수동으로 구매하려는 갯수가 총 갯수보다 많습니다!!");
        }
        System.out.printf("수동으로 구매할 번호를 입력해 주세요\n");
        Scanner s2 = new Scanner(System.in);
        Utility ut = new Utility();
        for (int i=0;i<this.mySelfLottoCounts;i++){
            String str = s2.nextLine();
            EmptyLotto emptyLotto = new EmptyLotto(ut.transStringToIntegerList(str));
            lottoList.add(emptyLotto);

        }

    }
}
