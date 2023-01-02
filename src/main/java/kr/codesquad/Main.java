package kr.codesquad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        LottoService lottoService = new LottoService(new InputView(), new OutputView(), new Lotto(new NumberGenerator()));
        lottoService.buyLotto();
    }
}