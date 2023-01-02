package kr.codesquad;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class WinnerChecker {

  public WinningResult check(
      List<LottoNumbers> numbersList,
      LottoNumbers winningNumber
  ) {
    Map<WinningAmount, Integer> map = Arrays.stream(WinningAmount.values())
                                            .collect(Collectors.toMap(w -> w, w -> 0, (a, b) -> b));

    numbersList.stream()
               .mapToInt(winningNumber::countMatch)
               .mapToObj(WinningAmount::from)
               .filter(Optional::isPresent)
               .map(Optional::get)
               .filter(map::containsKey)
               .forEach(winningAmount -> map.put(winningAmount, map.get(winningAmount) + 1));

    return WinningResult.from(map);
  }

}
