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
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<purchaseCount;i++) {
            int lottoGenerationMethod = i < manualLottoPurchaseCount ?
                    LottoGenerationMethod.MANUAL.getMethod() : LottoGenerationMethod.AUTO.getMethod();
            lottos.add(LottoGenerationMethod.generateEmptyLotto(lottoGenerationMethod, input));
        }
        return lottos;
    }
}

