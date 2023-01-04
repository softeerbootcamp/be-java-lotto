package kr.codesquad.domain.lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoFactory {

  private static final int LOTTO_NUMBER_BOUND = 45;
  private static final int LOTTO_NUMBER_COUNT = 6;

  private final RandomNumberFactory randomNumberFactory = new RandomNumberFactory(LOTTO_NUMBER_BOUND);

  public Lotto generate() {
    Set<Integer> numberSet = getRandomNumberSet();
    List<Integer> numberList = new ArrayList<>(numberSet);

    List<Integer> lottoNumbers = numberList.subList(0, LOTTO_NUMBER_COUNT);
    lottoNumbers.sort(Comparator.naturalOrder());

    return Lotto.from(lottoNumbers);
  }

  private Set<Integer> getRandomNumberSet() {
    Set<Integer> numberSet = new HashSet<>();
    while (numberSet.size() < LottoFactory.LOTTO_NUMBER_COUNT) {
      numberSet.add(randomNumberFactory.generate());
    }
    return numberSet;
  }

}
