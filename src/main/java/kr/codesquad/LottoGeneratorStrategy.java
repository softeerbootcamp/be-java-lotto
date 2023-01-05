package kr.codesquad;

import java.util.List;

public interface LottoGeneratorStrategy {
	final int LOTTO_NUMBER_COUNT = 6;

	List<Lotto> generate(int cnt);
}
