package kr.codesquad.lottoSystem;

import kr.codesquad.UserInput;
import kr.codesquad.exception.CustomException;
import kr.codesquad.lotto.AutoLotto;
import kr.codesquad.lotto.Lotto;
import kr.codesquad.lotto.ManualLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private final int lottoPrice; // 로또 하나의 가격 정보
    private final List<Integer> numList;
    
    private static final UserInput ui = new UserInput();

    public LottoMachine(int lottoPrice) {
        this.lottoPrice = lottoPrice;
        this.numList = new ArrayList<>();
        for(int i = 1;i <= 45;i++) this.numList.add(i);
    }

    public Lotto buyLotto() {
        int money = ui.inputMoney(); // 구입금액 입력

        int possibleLottoCount = money / lottoPrice;
        // 수동으로 구매할 로또 개수 입력
        int manualLottoCount = ui.inputManualLottoCount();
        if(manualLottoCount > possibleLottoCount) throw new CustomException("금액이 충분하지 않습니다.");

        // 수동으로 구매할 로또 번호 입력
        List<List<Integer>> manualLottoList = ui.inputManualLottoList(manualLottoCount);

        int autoLottoCount = possibleLottoCount - manualLottoCount;
        System.out.println("수동으로 " + manualLottoCount + "장, 자동으로 " + autoLottoCount + "개를 구매했습니다.");

        return new ManualLotto(manualLottoList, new AutoLotto(shuffle(autoLottoCount), null));
    }

    public List<List<Integer>> shuffle(int lottoCount) {
        List<List<Integer>> lottoList = new ArrayList<>();

        for(int i = 0;i < lottoCount;i++) {
            Collections.shuffle(numList);
            List<Integer> subList = new ArrayList<>(numList.subList(0, 6));

            lottoList.add(subList);
            Collections.sort(lottoList.get(i));
        }

        return lottoList;
    }

    public void printLottoList(List<List<Integer>> lottoList) {
        for(List<Integer> eachLotto : lottoList) System.out.println(eachLotto);
    }
}