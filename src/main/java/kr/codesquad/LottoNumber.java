package kr.codesquad;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber {
	private final int number;
	private static Map<Integer, LottoNumber> numberMap = new HashMap<>();

	static {
		for (int i = 0; i < 46; i++) {
			numberMap.put(i, new LottoNumber(i));
		}
	}

	private LottoNumber(int number) {
		if (number < 0 || number > 45) {
			throw new IllegalArgumentException("잘못된 로또 번호 입력입니다.");
		}
		this.number = number;
	}

	public static LottoNumber of(String number) {
		return numberMap.get(Integer.parseInt(number));
	}

	public static LottoNumber of(int number) {
		return numberMap.get(number);
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}

}
