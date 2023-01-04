package kr.codesquad.LottoService;

import kr.codesquad.Rank;

import java.util.*;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    List<Integer> numbers;

    private final Set<LottoNumber> lotto;
    private Lotto(Set<LottoNumber> lotto) {
        if (lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }

        this.lotto = lotto;
    }

    public static Lotto of(List<Integer> numbers) {
        Set<LottoNumber> lotto = new HashSet<>();
        for (Integer number : numbers) {
            lotto.add(LottoNumber.of(number));
        }
        return new Lotto(lotto);
    }

    Rank getMatchRank(Set<Integer> winningNumberSet, int bonusNumber) {
        int matchNumberCount = (int) numbers.stream().filter(winningNumberSet::contains).count();
        if (matchNumberCount == Rank.FIRST.getCountOfMatch())
            return Rank.FIRST;
        if (matchNumberCount == Rank.SECOND.getCountOfMatch() || matchNumberCount == Rank.THIRD.getCountOfMatch())
            return numbers.contains(bonusNumber) ? Rank.SECOND : Rank.THIRD;
        if (matchNumberCount == Rank.FOURTH.getCountOfMatch())
            return Rank.FOURTH;
        if (matchNumberCount == Rank.FIFTH.getCountOfMatch())
            return Rank.FIFTH;
        return Rank.ETC;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public int match(Lotto target) {
        int count = 0;
        for (LottoNumber lottoNumber : lotto) {
            count += target.increment(lottoNumber);
        }
        return count;
    }

    private int increment(LottoNumber lottoNumber) {
        if (contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }
}
