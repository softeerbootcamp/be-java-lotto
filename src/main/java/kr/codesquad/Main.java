package kr.codesquad;

import kr.codesquad.domain.lotto.factory.LottoAutoFactory;
import kr.codesquad.domain.lotto.LottoShop;
import kr.codesquad.io.Console;

public class Main {

  public static void main(String[] args) {
    App app = new App(new Console(), new LottoShop(new LottoAutoFactory()));
    app.run();
  }

}
