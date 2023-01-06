package kr.codesquad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoIOManagerImpl implements LottoIOManager {

	private final Scanner scanner;

	public LottoIOManagerImpl() {
		this.scanner = new Scanner(System.in);
	}

	private int readNumber() {
		try {
			return Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자를 입력해주세요");
		}
	}

	@Override
	public int readPurchaseAmount() throws IOException {
		System.out.println("구입금액을 입력해주세요.");
		return readNumber();
	}

	@Override
	public int readManualLottoCount() throws IOException {
		System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
		return readNumber();
	}

	@Override
	public void printLottoCount(int manualLottoCount, int autoLottoCount) {
		System.out.println("수동으로 " + manualLottoCount + "장 자동으로 " + autoLottoCount + "장 구매했숩니다");
	}

	@Override
	public void printLottos(List<Lotto> lottos) {
		for (Lotto lotto : lottos) {
			System.out.println(lotto);
		}
	}

	@Override
	public int readBonusBall() throws IOException {
		System.out.println("보너스 볼을 입력해주세요.");
		return readNumber();
	}

	@Override
	public WinningLotto readWinningLotto() throws IOException {
		System.out.println("당첨 번호를 입력해주세요.");
		String numbers = scanner.nextLine();
		List<Integer> lottoNumbers = new ArrayList<Integer>();
		for (String number : numbers.split(", ")) {
			lottoNumbers.add(Integer.parseInt(number));
		}

		return WinningLotto.of(Lotto.of(lottoNumbers), readBonusBall());
	}

	@Override
	public List<Lotto> readManualLotto(int cnt) {
		System.out.println("수동으로 구매할 번호를 입력해주세요.");
		List<Lotto> lottos = new ArrayList<Lotto>();
		for (int i = 0; i < cnt; i++) {
			String numbers = scanner.nextLine();
			List<Integer> lottoNumbers;
			lottoNumbers = readNumbers(numbers);
			lottos.add(Lotto.of(lottoNumbers));
		}

		return lottos;
	}

	private List<Integer> readNumbers(String numbers) {
		List<Integer> lottoNumbers;
		try {
			lottoNumbers = Arrays.stream(numbers.split(", ")).map(Integer::parseInt).collect(Collectors.toList());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("잘못된 입력입니다.");
		}
		return lottoNumbers;
	}

	@Override
	public void printResult(LottoResult lottoResult, int purchaseAmount) {
		System.out.println("당첨 통계");
		System.out.println("-----");
		System.out.println("3개 일치 (5000원) - " + lottoResult.getMatchLottoCount(LottoMatchType.THREE_MATCH));
		System.out.println("4개 일치 (50000원) - " + lottoResult.getMatchLottoCount(LottoMatchType.FOUR_MATCH));
		System.out.println("5개 일치 (1500000원) - " + lottoResult.getMatchLottoCount(LottoMatchType.FIVE_MATCH));
		System.out.println(
			"5개 일치, 보너스 볼 일치(30000000원) - " + lottoResult.getMatchLottoCount(LottoMatchType.BONUS_MATCH));
		System.out.println("6개 일치 (2000000000원) - " + lottoResult.getMatchLottoCount(LottoMatchType.SIX_MATCH));
		printEarningRate(lottoResult, purchaseAmount);
	}

	public void printEarningRate(LottoResult lottoResult, int purchaseAmount) {
		System.out.println(String.format("%.2f", lottoResult.getEarningRate(purchaseAmount)) + "%");
	}
}
