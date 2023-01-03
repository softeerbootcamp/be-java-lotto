package kr.codesquad.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final int purchaseAmount;
    private final int purchaseTicketCount;
    private final List<Lotto> lottos;
    private WinningStatic winningStatic = new WinningStatic();

    public User(int purchaseAmount, int purchaseTicketCount) {
        this.purchaseAmount = purchaseAmount;
        this.purchaseTicketCount = purchaseTicketCount;
        this.lottos=generateLottos(purchaseTicketCount);
    }



    private List<Lotto> generateLottos(int purchaseTickets) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int count = 0; count < purchaseTickets; count++) {
            lottoList.add(new Lotto());
        }
        return lottoList;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }


    public List<Lotto> getLottos() {
        return lottos;
    }


    public WinningStatic getWinningStatic() {
        return winningStatic;
    }
}
