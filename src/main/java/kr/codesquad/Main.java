package kr.codesquad;

import kr.codesquad.LottoService.LottoFactory.LottoFactory;
import kr.codesquad.LottoService.LottoStore;
import kr.codesquad.View.Console;
import kr.codesquad.View.IOManager;
import kr.codesquad.View.IOManagerImpl;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        Console console = new Console();
        IOManager ioManager = new IOManagerImpl();
        LottoStore lottoStore = new LottoStore(new LottoFactory(ioManager), new ArrayList<>(), new HashMap<>());
        App app = new App(console, lottoStore);
        app.run();
    }
}