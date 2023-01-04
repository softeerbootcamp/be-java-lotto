package kr.codesquad;

import java.util.List;

public interface LottoGenerator {
	public int LOTTO_NUMBER_COUNT = 6;

	public List<Lotto> generate(int count);
}
