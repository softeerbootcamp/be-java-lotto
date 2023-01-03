package kr.codesquad.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {

    private final int purchaseAmount;
    private final int purchaseTickets;
    private final List<Lotto> lottos;

    private HashMap<Result, Integer> resultMatch = new HashMap<>();

    public User(int purchaseAmount, int purchaseTickets) {
        this.purchaseAmount = purchaseAmount;
        this.purchaseTickets = purchaseTickets;
        this.lottos=generateLottos(purchaseTickets);
        initialResult();
    }

    protected void updateResult(int matchCount) {
        Result result = Result.getResult(matchCount);
        Integer winCount = resultMatch.get(result);
        resultMatch.put(result, winCount + 1);
    }

    private void initialResult() {
        for (Result result : Result.values()) {
            resultMatch.put(result, 0);
        }
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

    public HashMap<Result, Integer> getResultMatch() {
        return resultMatch;
    }
}
