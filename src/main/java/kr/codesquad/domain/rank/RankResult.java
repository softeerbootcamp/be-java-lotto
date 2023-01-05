package kr.codesquad.domain.rank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import kr.codesquad.domain.lotto.Lotto;

public class RankResult {

  private final Map<Rank, Integer> map;

  public String getStatistics() {
    return map.keySet()
              .stream()
              .sorted()
              .map(this::getWinningAmountStatics)
              .collect(Collectors.joining());
  }

  public long getTotalWinningMoney() {
    return map.keySet()
              .stream()
              .mapToLong(rank -> (long)rank.getPrice() * map.get(rank))
              .sum();
  }

  public static RankResult createResult(
      List<Lotto> lottos,
      WinnerLotto winnerLotto
  ) {
    RankResult rankResult = new RankResult();
    rankResult.calculateResult(lottos, winnerLotto);
    return rankResult;
  }

  private RankResult() {
    this.map = Arrays.stream(Rank.values())
                     .collect(Collectors.toMap(w -> w, w -> 0, (a, b) -> b));
  }

  private void calculateResult(
      List<Lotto> lottos,
      WinnerLotto winnerLotto
  ) {
    lottos.stream()
          .map(winnerLotto::check)
          .filter(Optional::isPresent)
          .map(Optional::get)
          .filter(map::containsKey)
          .forEach(rank -> map.put(rank, map.get(rank) + 1));
  }

  private String getWinningAmountStatics(Rank rank) {
    return rank.toString() + String.format(" %d개\n", map.get(rank));
  }

}
