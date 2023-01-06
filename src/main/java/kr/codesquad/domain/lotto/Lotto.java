package kr.codesquad.domain.lotto;

import kr.codesquad.domain.Rank;
import kr.codesquad.domain.lotto.factory.LottoFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_PRICE = 1000;
    private static final int BONUS_COUNT = 5;
    private static final int COUNT = 6;

    private final List<LottoNumber> lotto;

    public Lotto(LottoFactory lottoFactory) {
        lotto = new ArrayList<>(lottoFactory.generateLottoNumbers());
    }

    public Lotto(List<Integer> lottoNumbers) {
        checkNumbers(lottoNumbers);
        this.lotto = lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public boolean contains(LottoNumber number) {
        return lotto.contains(number);
    }

    public Rank getRank(WinLotto winLotto) {
        int matchCount = getMatchCount(winLotto.getWinLotto());
        if (matchCount == BONUS_COUNT && lotto.contains(winLotto.getBonusBall())) {
            return Rank.getRank(matchCount, true);
        }
        return Rank.getRank(matchCount, false);
    }

    private int getMatchCount(Lotto targetLotto) {
        return (int) lotto.stream()
                .filter(targetLotto::contains)
                .count();
    }

    private void checkNumbers(List<Integer> inputNumbers) {
        if (inputNumbers.size() != COUNT) {
            throw new RuntimeException("로또 숫자를 6개 입력해 주세요.");
        }
        if (inputNumbers.stream().distinct().count() != COUNT) {
            throw new RuntimeException("중복된 로또 번호가 있습니다.");
        }
    }

    public List<Integer> getLotto() {
        return lotto
                .stream()
                .map(LottoNumber::getLottoNumber).collect(Collectors.toList());
    }

}
