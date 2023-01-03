package kr.codesquad;

import java.io.IOException;
import java.util.List;

public interface LottoCheck {
    List<Integer> moneyOfLottoList = List.of(0 ,0, 0, 5000, 50000, 1500000, 2000000000);
    void check(LottoTicket lottoTicket) throws IOException;
}
