package kr.codesquad.domain.lotto.factory;

import static kr.codesquad.domain.lotto.Lotto.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.domain.lotto.RandomNumberFactory;

public class LottoAutoFactory implements LottoFactory {

  private final RandomNumberFactory randomNumberFactory
      = new RandomNumberFactory(LOTTO_NUMBER_LOWER_BOUND, LOTTO_NUMBER_UPPER_BOUND);

  @Override
  public List<Lotto> generate(int count) {
    return IntStream.range(0, count)
                    .mapToObj(i -> generateOne())
                    .collect(Collectors.toList());
  }

  private Lotto generateOne() {
    Set<Integer> numberSet = getRandomNumberSet();
    List<Integer> numberList = new ArrayList<>(numberSet);

    List<Integer> lottoNumbers = numberList.subList(0, LOTTO_NUMBER_COUNT);
    lottoNumbers.sort(Comparator.naturalOrder());

    return Lotto.from(lottoNumbers);
  }

  private Set<Integer> getRandomNumberSet() {
    Set<Integer> numberSet = new HashSet<>();
    while (numberSet.size() < LOTTO_NUMBER_COUNT) {
      numberSet.add(randomNumberFactory.generate());
    }
    return numberSet;
  }

}
