package kr.codesquad.domain;

import kr.codesquad.view.IOManager;

import java.util.ArrayList;
import java.util.List;

public class LottoIssue {
    private final LottoFactory lottoFactory;
    private final IOManager ioManager;

    public LottoIssue(LottoFactory lottoFactory, IOManager ioManager) {
        this.lottoFactory = lottoFactory;
        this.ioManager = ioManager;
    }

    public List<Lotto> issueLotto(int manualLottoCount, int autoLottoCount){
        List<Lotto> lottos = new ArrayList<>();
        System.out.println("\n수동으로 구매할 번호를 입력해주세요.");

        for (int i = 0 ; i < manualLottoCount ; i++) {
            lottos.add(lottoFactory.generateLotto("manual"));
        }
        for (int i = 0 ; i < autoLottoCount ; i++) {
            lottos.add(lottoFactory.generateLotto("auto"));
        }
        return lottos;
    }

    public WinningLotto issueWinningLotto(){
        Lotto lotto = lottoFactory.generateLotto("winning");
        int bo = ioManager.inputBonusNumber();
        return new WinningLotto(lotto, bo);
    }
}
