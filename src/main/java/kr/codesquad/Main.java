package kr.codesquad;

import kr.codesquad.domain.lotto.LottoFactory;
import kr.codesquad.io.Console;

public class Main {

  public static void main(String[] args) {
    App app = new App(new Console(), new LottoFactory());
    app.run();
  }

}
