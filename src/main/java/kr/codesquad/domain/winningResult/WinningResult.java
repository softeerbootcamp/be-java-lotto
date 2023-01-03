package kr.codesquad.domain.winningResult;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import kr.codesquad.domain.lotto.Lotto;

public class WinningResult {

  private final Map<WinningAmount, Integer> map;

  private static final String DISPLAY_FORM = "%d 개 일치 (%d 원)- %d\n";

  public WinningResult() {
    this.map = Arrays.stream(WinningAmount.values())
                     .collect(Collectors.toMap(w -> w, w -> 0, (a, b) -> b));
  }

  public void calculateResult(
      List<Lotto> lottos,
      Lotto winningLotto
  ) {
    lottos.stream()
          .mapToInt(winningLotto::countMatch)
          .mapToObj(WinningAmount::from)
          .filter(Optional::isPresent)
          .map(Optional::get)
          .filter(map::containsKey)
          .forEach(winningAmount -> map.put(winningAmount, map.get(winningAmount) + 1));
  }

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

  private String getWinningAmountStatics(WinningAmount winningAmount) {
    return String.format(
        DISPLAY_FORM, winningAmount.getCorrectCount(), winningAmount.getPrice(), map.get(winningAmount));
  }

}
