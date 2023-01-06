package kr.codesquad.model;

import kr.codesquad.model.lotto.AutoLotto;
import kr.codesquad.model.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final Money money;
    private final Ticket ticket;
    private List<Lotto> lottos;
    private ResultStatistic resultStatistic = new ResultStatistic();

    public User(Money money,Ticket ticket) {
        this.money = money;
        this.ticket = ticket;
        this.lottos=generateLottos(ticket.getAutoTicketsCount());
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


    public Money getMoney() {
        return money;
    }

    public Ticket getTicket() {
        return ticket;
    }
}
