package kr.codesquad.model;

import kr.codesquad.model.lotto.AutoLotto;
import kr.codesquad.model.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final int purchaseAmount;
    private final int manualTicketsCount;
    private final int autoTicketsCount;
    private List<Lotto> lottos;
    private WinningStatistic winningStatistic = new WinningStatistic();

    public User(int purchaseAmount, int manualTicketsCount, int autoTicketsCount) {
        this.purchaseAmount = purchaseAmount;
        this.manualTicketsCount=manualTicketsCount;
        this.autoTicketsCount=autoTicketsCount;
        this.lottos=generateLottos(autoTicketsCount);
    }

    public void insertLotto(Lotto lotto) {
        lottos.add(lotto);
    }



    private List<Lotto> generateLottos(int purchaseTickets) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int count = 0; count < purchaseTickets; count++) {
            lottoList.add(new AutoLotto());
        }
        return lottoList;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }


    public List<Lotto> getLottos() {
        return lottos;
    }


    public WinningStatistic getWinningStatic() {
        return winningStatistic;
    }

    public int getManualTicketsCount() {
        return manualTicketsCount;
    }

    public int getAutoTicketsCount() {
        return autoTicketsCount;
    }
}
