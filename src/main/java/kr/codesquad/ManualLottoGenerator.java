package kr.codesquad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManualLottoGenerator implements LottoGenerator {
	@Override
	public List<Lotto> generate(int count) {
		System.out.println("수동으로 구매 번호를 입력해주세요.");
		List<Lotto> lottoList = new ArrayList<Lotto>();
		Scanner scanner = new Scanner(System.in);
		String numbers = scanner.nextLine();
		List<Integer> lottoNumbers = new ArrayList<Integer>();
		for (String number : numbers.split(", ")) {
			lottoNumbers.add(Integer.parseInt(number));
		}
		lottoList.add(Lotto.of(lottoNumbers));

		return lottoList;
	}
}
