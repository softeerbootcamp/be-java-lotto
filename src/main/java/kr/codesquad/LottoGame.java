package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LottoGame {

	private final static int LOTTO_PRICE = 1000;
	private final static int LOTTO_NUMBER_COUNT = 6;

	public List<Integer> lottoNumbers;

	public LottoGame() {
		lottoNumbers = new ArrayList<>();
		for (int i = 1; i <= 45; i++) {
			lottoNumbers.add(i);
		}
	}

	public void compareEachLotto(Lotto purchasedLotto, WinningLotto winningLotto, LottoResult lottoResult) {
		LottoMatchType lottoMatchType = winningLotto.matchLotto(purchasedLotto);
		lottoResult.updateResult(lottoMatchType.getMatchCount(), 1);
	}

	public LottoResult checkMyLotto(List<Lotto> purchasedLottoList, WinningLotto winningLotto) {
		LottoResult lottoResult = new LottoResult();
		for (Lotto lotto : purchasedLottoList) {
			System.out.println(lotto);
			compareEachLotto(lotto, winningLotto, lottoResult);
		}

		return lottoResult;
	}

	public Lotto getNewLotto() {
		Collections.shuffle(lottoNumbers);
		List<Integer> newLottoNumbers = new ArrayList<>(lottoNumbers.subList(0, LOTTO_NUMBER_COUNT));
		Collections.sort(newLottoNumbers);

		return Lotto.of(newLottoNumbers);
	}

	public int getPurchaseAmount() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("구입금액을 입력해 주세요.");

		return scanner.nextInt();
	}

	public int getLottoCount(int purchaseAmount) {
		int lottoCount = purchaseAmount / LOTTO_PRICE;
		System.out.println(lottoCount + "개를 구입하였습니다.");

		return lottoCount;
	}

	public ArrayList<Lotto> purchaseLottoList() {
		int purchaseAmount = getPurchaseAmount();
		int lottoCount = getLottoCount(purchaseAmount);
		ArrayList<Lotto> lottoList = new ArrayList<Lotto>();
		for (int i = 0; i < lottoCount; i++) {
			lottoList.add(getNewLotto());
			System.out.println(lottoList.get(i));
		}

		return lottoList;
	}

	public int getBonusBall() {
		System.out.println("보너스 볼을 입력해주세요.");
		Scanner scanner = new Scanner(System.in);

		return scanner.nextInt();
	}

	public WinningLotto createWinningLottery() {
		System.out.println("당첨 번호를 입력해주세요");
		Scanner scanner = new Scanner(System.in);
		String numbers = scanner.nextLine();
		List<Integer> lottoNumbers = new ArrayList<Integer>();
		for (String number : numbers.split(", ")) {
			lottoNumbers.add(Integer.parseInt(number));
		}

		return WinningLotto.of(Lotto.of(lottoNumbers), getBonusBall());
	}
}
