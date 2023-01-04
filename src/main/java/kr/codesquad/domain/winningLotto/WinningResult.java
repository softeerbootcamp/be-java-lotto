package kr.codesquad.domain.winningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import kr.codesquad.domain.lotto.Lotto;

public class WinningResult {

  private final Map<WinningAmount, Integer> map;

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
              .mapToLong(winningAmount -> (long)winningAmount.getPrice() * map.get(winningAmount))
              .sum();
  }

  public static WinningResult createResult(
      List<Lotto> lottos,
      WinningLotto winningLotto
  ) {
    WinningResult winningResult = new WinningResult();
    winningResult.calculateResult(lottos, winningLotto);
    return winningResult;
  }

  private WinningResult() {
    this.map = Arrays.stream(WinningAmount.values())
                     .collect(Collectors.toMap(w -> w, w -> 0, (a, b) -> b));
  }

  private void calculateResult(
      List<Lotto> lottos,
      WinningLotto winningLotto
  ) {
    lottos.stream()
          .map(winningLotto::check)
          .filter(Optional::isPresent)
          .map(Optional::get)
          .filter(map::containsKey)
          .forEach(winningAmount -> map.put(winningAmount, map.get(winningAmount) + 1));
  }

  private String getWinningAmountStatics(WinningAmount winningAmount) {
    return winningAmount.toString() + String.format(" %d개\n", map.get(winningAmount));
  }

}
