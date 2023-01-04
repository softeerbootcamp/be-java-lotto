package kr.codesquad.domain.lotto.factory;

import java.util.List;

import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.io.Console;

public class LottoManualFactory implements LottoFactory {

  private final Console console;

  public LottoManualFactory(Console console) {
    this.console = console;
  }

  @Override
  public Lotto generate() {
    List<Integer> lottoNumbers = console.inputWinningNumbers();
    return Lotto.from(lottoNumbers);
  }

}
