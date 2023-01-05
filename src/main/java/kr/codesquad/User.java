package kr.codesquad;


import kr.codesquad.LottoService.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private static final int MONEY_PER_LOTTO = 1_000;
    private int money;
    private List<Lotto> lottos;

    public User(int money){
        if (money < MONEY_PER_LOTTO || money % MONEY_PER_LOTTO != 0){
            throw new IllegalArgumentException("유효하지 않은 금액입니다. 1000원 단위로 입력해주세요.");
        }
        this.money = money;
        this.lottos = new ArrayList<>();
    }

    public int countOfBuying(){
        return money / MONEY_PER_LOTTO;
    }

    public void setLottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getMoney() {
        return money;
    }
}
