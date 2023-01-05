package kr.codesquad.lotto.issue;

import kr.codesquad.lotto.Lotto;
import kr.codesquad.lotto.LottoNumber;
import kr.codesquad.lotto.io.LottoIOManager;

import java.util.*;

public class ManualLottoIssueStrategy implements LottoIssueStrategy {

    private final LottoIOManager lottoIOManager;

    public ManualLottoIssueStrategy(LottoIOManager lottoIOManager) {
        this.lottoIOManager = lottoIOManager;
    }

    @Override
    public List<Lotto> issue(int cnt) {
        List<Lotto> lottoList = new ArrayList<>(cnt);
        int lottoCnt = lottoIOManager.readLottoCount("수동으로 구매할 로또 수를 입력해 주세요.");

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int idx = 0; idx < lottoCnt; idx++) {
            Set<LottoNumber> lottoNumberSet = lottoIOManager.readLottoNumberSet("");
            lottoList.add(new Lotto(lottoNumberSet));
        }

        return lottoList;
    }
}
