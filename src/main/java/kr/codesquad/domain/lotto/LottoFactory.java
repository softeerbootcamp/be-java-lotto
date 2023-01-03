package kr.codesquad.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoFactory {

  private static final int LOTTO_NUMBER_BOUND = 45;
  private static final int LOTTO_NUMBER_COUNT = 6;

  private final RandomNumberFactory randomNumberFactory = new RandomNumberFactory(LOTTO_NUMBER_BOUND);

  public Lotto generate() {
    Set<Integer> resultSet = new HashSet<>();

    while (resultSet.size() < LOTTO_NUMBER_COUNT) {
      resultSet.add(randomNumberFactory.generate());
    }

    List<Integer> resultList = resultSet.stream()
                                        .sorted()
                                        .collect(Collectors.toList());

    return Lotto.from(resultList);
  }

}
