package kr.codesquad;

import kr.codesquad.lotto.LottoMachine;
import kr.codesquad.lotto.LottoMachineFactory;
import kr.codesquad.lotto.LottoTicket;
import kr.codesquad.lotto.Rank;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LottoMachine lottoMachine = LottoMachineFactory.createLottoMachine();
        LottoTicket lottoTicket = lottoMachine.buy();
        Map<Rank, Integer> rankStatus = lottoMachine.checkWin(lottoTicket);

        for (Rank rank: rankStatus.keySet()) {
            System.out.println(rank.getCountOfMatch() + ": " + rankStatus.get(rank) + "개");
        }
    }
}