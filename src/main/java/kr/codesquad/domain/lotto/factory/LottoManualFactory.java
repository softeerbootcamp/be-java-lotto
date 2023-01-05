package kr.codesquad.domain.lotto.factory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.common.io.Console;

public class LottoManualFactory implements LottoFactory {

  private final Console console = new Console();

  @Override
  public List<Lotto> generate(int count) {
    console.printInputManualLottoNumbers();
    return IntStream.range(0, count)
                    .mapToObj(i -> console.inputLottoNumbers())
                    .map(Lotto::from)
                    .collect(Collectors.toList());
  }

}
