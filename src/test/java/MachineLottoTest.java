import kr.codesquad.exception.CustomException;
import kr.codesquad.utils.Utility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class MachineLottoTest {
    @DisplayName("구매 금액이 음수이면 예외 처리")
    @Test
    void checkMoneyIfNegative() {
        assertThatThrownBy(() -> Utility.checkAmountOfMoney(-2000))
                .isInstanceOf(CustomException.class);
    }

    @DisplayName("구매 금액이 1000 미만이면 예외 처리")
    @Test
    void checkMoneyIfLack() {
        assertThatThrownBy(() -> Utility.checkAmountOfMoney(900))
                .isInstanceOf(CustomException.class);
    }
}
