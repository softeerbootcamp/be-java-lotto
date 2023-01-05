package kr.codesquad;

import kr.codesquad.input.Input;
import kr.codesquad.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final int purchaseCount;

    private final int manualLottoPurchaseCount;

    private LottoGenerator(int money, int manualLottoPurchaseCount) {
        this.purchaseCount = money / Lotto.PRICE;
        this.manualLottoPurchaseCount = manualLottoPurchaseCount;
    }

    public static LottoGenerator of(int money, int manualLottoPurchaseCount) {
        return new LottoGenerator(money, manualLottoPurchaseCount);
    }

    public List<Lotto> generateLottos(Input input) {
        List<Lotto> lottos = new ArrayList<>(LottoGenerationImpl.of(manualLottoPurchaseCount, new ManualLottoGenerationMethodImpl(input), input).generate());
        lottos.addAll(LottoGenerationImpl.of(purchaseCount - manualLottoPurchaseCount, new AutoLottoGenerationMethodImpl(), input).generate());
        System.out.println("수동으로 " + manualLottoPurchaseCount + "개, 자동으로 " + (purchaseCount - manualLottoPurchaseCount) +"개를 구매했습니다");
        for(Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        return lottos;
    }
}

