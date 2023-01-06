package kr.codesquad.model;

import kr.codesquad.model.lotto.Lotto;
import kr.codesquad.model.lotto.WinningLotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private final int purchaseMoney;
    private final int manualLottoCount;
    private final int autoLottoCount;
    private final List<Lotto> lottos;

    public User(int purchaseMoney, int manualLottoCount, int autoLottoCount, List<Lotto> lottos) {
        this.purchaseMoney = purchaseMoney;
        this.manualLottoCount = manualLottoCount;
        this.autoLottoCount = autoLottoCount;
        this.lottos = lottos;
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    public int getAutoLottoCount() {
        return autoLottoCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<Rank, Integer> compare(WinningLotto winningLotto) {
        Map<Rank, Integer> result = new HashMap<>();
        lottos.forEach(lotto -> {
            Rank rank = winningLotto.compare(lotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        });

        return result;
    }
}
