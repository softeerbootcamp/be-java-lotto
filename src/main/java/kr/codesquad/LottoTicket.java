package kr.codesquad;

import java.util.List;

public class LottoTicket {
    private final List<List<Integer>> lottoList;
    private final int money;

    public LottoTicket(List<List<Integer>> lottoList, int money) {
        this.lottoList = lottoList;
        this.money = money;
    }

    public List<List<Integer>> getLottoList() {
        return lottoList;
    }

    public int getMoney() {
        return money;
    }
}
