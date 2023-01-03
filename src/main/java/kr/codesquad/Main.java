package kr.codesquad;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		LottoGame lottoGame = new LottoGame();
		List<Lotto> purchasedLottoList = lottoGame.purchaseLottoList();
		WinningLotto winningLotto = lottoGame.createWinningLottery();
		LottoResult lottoResult = lottoGame.checkMyLotto(purchasedLottoList, winningLotto);
		lottoResult.printResult(purchasedLottoList.size());
	}
}