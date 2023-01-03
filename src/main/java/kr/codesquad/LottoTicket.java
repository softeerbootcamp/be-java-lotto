package kr.codesquad;

import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottoList;
    private final int money;

    public LottoTicket(List<Lotto> lottoList, int money) {
        this.lottoList = lottoList;
        this.money = money;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getMoney() {
        return money;
    }
}
