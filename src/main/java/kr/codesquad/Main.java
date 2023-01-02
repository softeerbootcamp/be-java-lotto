package kr.codesquad;

import kr.codesquad.InputService.InputService;
import kr.codesquad.InputService.InputServiceImpl;
import kr.codesquad.LottoService.LottoService;
import kr.codesquad.LottoService.LottoServiceImpl;

public class Main {
    public static void main(String[] args) {
        InputService inputService = new InputServiceImpl();
        LottoService lottoService = new LottoServiceImpl();

        inputService.inputMoney();
        inputService.printLottoCount();
        lottoService.setLottoNumbers(inputService.getLottoCount());
        lottoService.printLottos();

        inputService.inputWinningNumber();
        lottoService.setWinningNumbers(inputService.getWinningNumberList());
        lottoService.printWinningLottos();
        lottoService.calculateEarningRate(inputService.getLottoCount());
    }
}