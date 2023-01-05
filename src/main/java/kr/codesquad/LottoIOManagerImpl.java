package kr.codesquad;

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

	@Override
	public int readPurchaseAmount() {
		System.out.println("구입금액을 입력해주세요.");

		return Integer.parseInt(scanner.nextLine());
	}

	@Override
	public int readManualLottoCount() {
		System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
		return Integer.parseInt(scanner.nextLine());
	}

	@Override
	public int getAutoLottoCount(int purchaseAmount, int manualLottoCount) {
		return 0;
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
	public int readBonusBall() {
		System.out.println("보너스 볼을 입력해주세요.");

		return Integer.parseInt(scanner.nextLine());
	}

	@Override
	public WinningLotto readWinningLotto() {
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
			lottoNumbers = Arrays.stream(numbers.split(", ")).map(Integer::parseInt).collect(Collectors.toList());
			lottos.add(Lotto.of(lottoNumbers));
		}

		return lottos;
	}
}
