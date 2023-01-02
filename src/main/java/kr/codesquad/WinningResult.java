package kr.codesquad;

import java.util.Map;
import java.util.stream.Collectors;

public class WinningResult {

  private final Map<WinningAmount, Integer> map;

  private static final String DISPLAY_FORM = "%d 개 일치 (%d 원)- %d\n";

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

  private WinningResult(Map<WinningAmount, Integer> map) {
    this.map = map;
  }

  private String getWinningAmountStatics(WinningAmount winningAmount) {
    return String.format(
        DISPLAY_FORM, winningAmount.getCorrectCount(), winningAmount.getPrice(), map.get(winningAmount));
  }

  public static WinningResult from(Map<WinningAmount, Integer> map) {
    return new WinningResult(map);
  }

}
