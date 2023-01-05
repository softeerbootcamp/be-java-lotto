package kr.codesquad;

import kr.codesquad.lotto.*;

public class Main {
    public static void main(String[] args) {
        LottoMachine lottoMachine = LottoMachineFactory.createLottoMachine();
        LottoTicket lottoTicket = lottoMachine.buy();
        LottoResult lottoResult = lottoMachine.check(lottoTicket);
        lottoResult.print();
    }
}