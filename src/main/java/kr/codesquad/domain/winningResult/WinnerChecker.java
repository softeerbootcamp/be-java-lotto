package kr.codesquad.domain.winningResult;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import kr.codesquad.domain.lotto.Lotto;

public class WinnerChecker {

  public WinningResult check(
      List<Lotto> lottos,
      Lotto winningLotto
  ) {
    Map<WinningAmount, Integer> map = Arrays.stream(WinningAmount.values())
                                            .collect(Collectors.toMap(w -> w, w -> 0, (a, b) -> b));

    lottos.stream()
          .mapToInt(winningLotto::countMatch)
          .mapToObj(WinningAmount::from)
          .filter(Optional::isPresent)
          .map(Optional::get)
          .filter(map::containsKey)
          .forEach(winningAmount -> map.put(winningAmount, map.get(winningAmount) + 1));

    return WinningResult.from(map);
  }

}
