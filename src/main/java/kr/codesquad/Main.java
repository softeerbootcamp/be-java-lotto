package kr.codesquad;

import kr.codesquad.lotto.LottoMachine;
import kr.codesquad.lotto.LottoMachineFactory;
import kr.codesquad.lotto.LottoTicket;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LottoMachine lottoMachine = LottoMachineFactory.createLottoMachine();
        LottoTicket lottoTicket = lottoMachine.buy();
        lottoMachine.checkWin(lottoTicket);
    }
}