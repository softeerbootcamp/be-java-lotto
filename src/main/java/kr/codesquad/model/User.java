package kr.codesquad.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private final int purchaseAmount;
    private final int purchaseTickets;
    private final List<Lotto> lottos;
    private WinningStatic winningStatic = new WinningStatic();

    public User(int purchaseAmount, int purchaseTickets) {
        this.purchaseAmount = purchaseAmount;
        this.purchaseTickets = purchaseTickets;
        this.lottos=generateLottos(purchaseTickets);
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
