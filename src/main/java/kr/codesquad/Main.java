package kr.codesquad;

import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		LottoGame lottoGame = LottoGameCreator.createLottoGame();
		// 로또 사기
		List<Lotto> buyLottos = lottoGame.buy();
		// 로또 추첨하기
		WinningLotto winningLotto = lottoGame.createWinningLottery();
		// 로또 결과 비교하기
		LottoResult lottoResult = lottoGame.checkLotto(buyLottos, winningLotto);
		// 로또 결과 출력하기
		lottoGame.printLottoResult(lottoResult, buyLottos.size());

	}
}