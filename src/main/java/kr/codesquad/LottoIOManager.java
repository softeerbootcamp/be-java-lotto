package kr.codesquad;

import java.io.IOException;
import java.util.List;

public interface LottoIOManager {


	public int readPurchaseAmount() throws IOException;

	public int readManualLottoCount() throws IOException;

	public void printLottoCount(int manualCount, int autoLottoCount);

	public void printLottos(List<Lotto> lottos);


	public int readBonusBall() throws IOException;

	public WinningLotto readWinningLotto() throws IOException;

	public List<Lotto> readManualLotto(int cnt);

	public void printResult(LottoResult lottoResult, int purchaseAmount);
}
