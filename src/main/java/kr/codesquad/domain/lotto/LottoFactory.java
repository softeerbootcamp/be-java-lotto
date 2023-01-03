package kr.codesquad.domain.lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoFactory {

  private static final int LOTTO_NUMBER_BOUND = 45;
  private static final int LOTTO_NUMBER_COUNT = 6;
  private static final int LOTTO_BONUS_NUMBER_COUNT = 1;

  private final RandomNumberFactory randomNumberFactory = new RandomNumberFactory(LOTTO_NUMBER_BOUND);

  public Lotto generate() {
    Set<Integer> numberSet = getRandomNumberSet(LOTTO_NUMBER_COUNT + LOTTO_BONUS_NUMBER_COUNT);
    List<Integer> numberList = new ArrayList<>(numberSet);

    List<Integer> lottoNumbers = numberList.subList(0, LOTTO_NUMBER_COUNT);
    lottoNumbers.sort(Comparator.naturalOrder());

    int bonusNumber = numberList.get(numberList.size() - 1);

    return Lotto.of(lottoNumbers, bonusNumber);
  }

  private Set<Integer> getRandomNumberSet(int num) {
    Set<Integer> numberSet = new HashSet<>();
    while (numberSet.size() < num) {
      numberSet.add(randomNumberFactory.generate());
    }
    return numberSet;
  }

}
