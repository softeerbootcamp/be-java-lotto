package kr.codesquad;

import java.util.List;

public interface LottoIOManager {

	public int readPurchaseAmount();

	public int readManualLottoCount();

	public int getAutoLottoCount(int purchaseAmount, int manualLottoCount);

	public void printLottoCount(int manualCount, int autoLottoCount);

	public void printLottos(List<Lotto> lottos);

	public int readBonusBall();

	public WinningLotto readWinningLotto();
}
