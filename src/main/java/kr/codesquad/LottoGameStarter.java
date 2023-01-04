package kr.codesquad;

import kr.codesquad.domain.Lotto;

import java.io.IOException;

public class LottoGameStarter {
    private final LottoViewer lottoViewer;

    public LottoGameStarter() {
        this.lottoViewer = new LottoViewer();
    }

    public void start() throws IOException {
        Lotto lotto = lottoViewer.home();
        lottoViewer.inputResult(lotto);
    }
}
