package kr.codesquad.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserLotto {

    private final List<Lotto> lottos;

    public UserLotto(List<Lotto> lottos) {
        this.lottos = lottos;
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
