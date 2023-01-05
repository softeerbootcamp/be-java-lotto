package kr.codesquad.util.error;

import kr.codesquad.model.lotto.Lotto;

public class MoneyErrorMessage extends CommonErrorMessage {


    public static final String  NOT_OVER_TICKET_PER_PRICE= "구입금액은"+ Lotto.TICKET_PER_PRICE+"원 이상이어야합니다";
    public static final String NOT_DIVIDE_TICKET_PER_PRICE = "구입금액은" + Lotto.TICKET_PER_PRICE + "원 단위로 가능합니다.";



}
