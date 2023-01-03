package kr.codesquad;

import kr.codesquad.LottoService.LottoService;
import kr.codesquad.LottoService.LottoServiceImpl;

public class Main {
    public static void main(String[] args) {
        Console console = new Console();
        LottoService lottoService = new LottoServiceImpl();

        console.inputMoney();
        console.printLottoCount();
        lottoService.setLottoNumbers(console.getLottoCount());
        lottoService.printLottos();

        console.inputWinningNumber();
        console.inputBonusNumber();
        lottoService.setWinningNumbers(console.getWinningNumberList(), console.getBonusNumber());
        lottoService.printWinningLottos();
        lottoService.calculateEarningRate(console.getLottoCount());
    }
}