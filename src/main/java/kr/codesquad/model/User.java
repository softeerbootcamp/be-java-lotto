package kr.codesquad.model;

import kr.codesquad.model.lotto.AutoLotto;
import kr.codesquad.model.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final Purchase purchase;
    private List<Lotto> lottos;
    private ResultStatistic resultStatistic = new ResultStatistic();

    public User(Purchase purchase) {
        this.purchase=purchase;
        this.lottos=generateLottos(purchase.getAutoTicketsCount());
    }

    public void insertManualLotto(Lotto manualLotto) {
        lottos.add(manualLotto);
    }



    private List<Lotto> generateLottos(int purchaseTickets) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int count = 0; count < purchaseTickets; count++) {
            lottoList.add(new AutoLotto());
        }
        return lottoList;
    }



    public List<Lotto> getLottos() {
        return lottos;
    }


    public ResultStatistic getWinningStatic() {
        return resultStatistic;
    }


    public Purchase getPurchase() {
        return purchase;
    }
}
