package kr.codesquad.domain.winningResult;

import static kr.codesquad.domain.winningResult.WinningAmount.*;

import java.util.Optional;

import kr.codesquad.domain.lotto.Lotto;

public class WinningAmountFactory {

  public static Optional<WinningAmount> generate(
      Lotto target,
      Lotto winner
  ) {
    WinningAmount result = null;

    switch (winner.countMatch(target)) {
      case 3:
        result = THREE;
        break;
      case 4:
        result = FOUR;
        break;
      case 5:
        result = winner.isBonusMatch(target) ? FIVE_WITH_BONUS : FIVE;
        break;
      case 6:
        result = SIX;
        break;
    }

    return Optional.ofNullable(result);
  }

}
