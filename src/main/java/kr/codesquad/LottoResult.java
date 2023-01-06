package kr.codesquad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoResult {
	private final List<Integer> result;

	public LottoResult() {
		result = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0));
	}

	public int getMatchLottoCount(LottoMatchType lottoMatchType) {
		return result.get(lottoMatchType.getMatchCount());
	}

	public void updateResult(int index, int cnt) {
		result.set(index, result.get(index) + cnt);
	}

	public int getProfit() {
		int profit = 0;
		for (int i = 0; i < LottoMatchType.values().length; i++) {
			profit += getMatchMoney(LottoMatchType.values()[i]);
		}

		return profit;
	}

	public double getEarningRate(int purchaseAmount) {
		int input = getProfit();
		if (purchaseAmount <= 0) {
			throw new IllegalArgumentException("구입 금액이 0보다 작을 수 없습니다.");
		}
		return ((input - purchaseAmount) / purchaseAmount) * 100;
	}

	public int getMatchMoney(LottoMatchType lottoMatchType) {
		return result.get(lottoMatchType.getMatchCount()) * lottoMatchType.getMoney();
	}

}
