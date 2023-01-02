package kr.codesquad;

import kr.codesquad.domain.lotto.LottoFactory;
import kr.codesquad.domain.winningResult.WinnerChecker;
import kr.codesquad.io.Console;

public class Main {

  public static void main(String[] args) {
    App app = new App(new Console(), new WinnerChecker(), new LottoFactory());
    app.run();
  }

}
