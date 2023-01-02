package kr.codesquad.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final int purchaseAmount;
    private final int purchaseTickets;
    private final List<Lotto> lottos;

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

    public int getPurchaseTickets() {
        return purchaseTickets;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
