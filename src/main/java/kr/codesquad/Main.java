package kr.codesquad;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LottoMachine lottoMachine = new LottoMachine(1000);
        LottoTicket lottoTicket = lottoMachine.buy();
        lottoMachine.checkWin(lottoTicket);
    }
}