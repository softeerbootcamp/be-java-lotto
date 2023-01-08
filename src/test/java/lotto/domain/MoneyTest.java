package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import kr.codesquad.domain.Money;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @Test
    public void createMoney_moneyLess1000_ExceptionThrown(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Money(0));
        assertThat(exception.getMessage()).isEqualTo("유효하지 않은 금액입니다. 1000원 단위로 입력해주세요.");
    }

    @Test
    public void createMoney_moneyNotDivided_ExceptionThrown(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Money(1500));
        assertThat(exception.getMessage()).isEqualTo("유효하지 않은 금액입니다. 1000원 단위로 입력해주세요.");
    }

    @Test
    public void createAndCheckMoney(){
        Money money = new Money(1000);
        assertThat(money.getMoney()).isEqualTo(1000);
    }
}
