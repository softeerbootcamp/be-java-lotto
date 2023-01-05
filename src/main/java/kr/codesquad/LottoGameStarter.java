package kr.codesquad;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.WinningNumbers;

import java.io.IOException;

public class LottoGameStarter {
    private final LottoViewer lottoViewer;

    public LottoGameStarter() {
        this.lottoViewer = new LottoViewer();
    }

    public void start() throws IOException {
        Lotto lotto = lottoViewer.home();
        WinningNumbers winningNumbers = lottoViewer.inputWinningNumbers();
        lottoViewer.result(lotto, winningNumbers);
    }
}
