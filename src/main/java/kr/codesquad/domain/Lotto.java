package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_SIZE = 6;
    private static final int BONUS_COUNT = 5;

    List<Integer> lotto;

    public Lotto() {
        this(choiceNumbers());
    }

    public Lotto(List<Integer> lottoNumbers) {
        this.lotto = new ArrayList<>(new ArrayList<>(lottoNumbers));
    }

    private static List<Integer> choiceNumbers() {
        List<Integer> numbers = generateNumbers();
        Collections.shuffle(numbers);

        return numbers.subList(0, LOTTO_SIZE)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static List<Integer> generateNumbers() {
        return IntStream.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    public boolean contains(int number) {
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
        return (int)lotto.stream()
                .filter(targetLotto::contains)
                .count();
    }

    public List<Integer> getLotto() {
        return new ArrayList<>(new ArrayList<>(lotto));
    }

}
