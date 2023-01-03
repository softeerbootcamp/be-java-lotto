package kr.codesquad;

import java.util.Arrays;

public enum LottoMatchType {
	MISS_MATCH(0, 0),
	THREE_MATCH(3, 5000),
	FOUR_MATCH(4, 50000),
	FIVE_MATCH(5, 1500000),
	SIX_MATCH(6, 2000000000),

	BONUS_MATCH(7, 30000000);

	LottoMatchType(int matchCount, int money) {
		this.matchCount = matchCount;
		this.money = money;
	}

	public static LottoMatchType getLottoMatchTypeByMatchCount(int matchCount) {
		if (matchCount < 3) {
			return MISS_MATCH;
		}
		return Arrays.stream(LottoMatchType.values())
			.filter(matchType -> matchType.matchCount == matchCount)
			.findFirst()
			.orElseThrow(IllegalArgumentException::new);
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getMoney() {
		return money;
	}

	private final int matchCount;
	private final int money;
}
