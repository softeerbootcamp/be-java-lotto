package kr.codesquad;

import kr.codesquad.io.Console;
import kr.codesquad.lotto.LottoPurchase;
import kr.codesquad.lotto.LottoService;

public class Main {

    public static void main(String[] args) {
        Application application = new Application(new Console(), new LottoService(), new LottoPurchase());
        application.start();
    }

}
