package kr.codesquad;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		LottoGame lottoGame = new LottoGame();
		// 로또 사기
		List<Lotto> buyLottoList = lottoGame.buyLottoList();
		// 로또 추첨하기
		WinningLotto winningLotto = lottoGame.createWinningLottery();
		// 로또 결과 비교하기
		LottoResult lottoResult = lottoGame.checkMyLotto(buyLottoList, winningLotto);
		// 로또 결과 출력하기
		lottoResult.printResult(buyLottoList.size());
	}
}