package kr.codesquad;

import kr.codesquad.LottoService.LottoFactory.LottoFactory;
import kr.codesquad.LottoService.LottoStore;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Console console = new Console();
        LottoStore lottoStore = new LottoStore(new LottoFactory(), new ArrayList<>(), new HashMap<>());
        App app = new App(console, lottoStore);
        app.run();
    }
}