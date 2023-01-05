package kr.codesquad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoGame {

	private final static int LOTTO_PRICE = 1000;

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


	public int getPurchaseAmount() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("구입금액을 입력해 주세요.");

		return scanner.nextInt();
	}

	public int getLottoCount(int purchaseAmount) {
		return purchaseAmount / LOTTO_PRICE;
	}

	public int getManualLottoCount() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("수동으로 구매할 로또 수 를 입력해 주세요");
		return scanner.nextInt();
	}

	public ArrayList<Lotto> buyLottoList() {
		// 금액 입력받기
		int purchaseAmount = getPurchaseAmount();
		// 수동 개수 입력
		int manualLottoCount = getManualLottoCount();
		// 자동 개수
		int autoLottoCount = getLottoCount(purchaseAmount) - manualLottoCount;
		ArrayList<Lotto> lottoList = new ArrayList<Lotto>();

		// 수동
		generateLottoList(lottoList, manualLottoCount, new ManualLottoGenerator());
		// 자동
		generateLottoList(lottoList, autoLottoCount, new AutoLottoGenerator());

		System.out.println("수동으로 " + manualLottoCount + "장 자동으로 " + autoLottoCount + "장 구매했숩니다");

		for (Lotto lotto : lottoList) {
			System.out.println(lotto);
		}

		return lottoList;
	}

	public void generateLottoList(List<Lotto> lottoList, int lottoCount, LottoGenerator lottoGenerator) {
		lottoList.addAll(lottoGenerator.generate(lottoCount));
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
