package kr.codesquad;

import java.io.IOException;

public interface LottoCheck {
    LottoResult check(LottoTicket lottoTicket) throws IOException;
}
