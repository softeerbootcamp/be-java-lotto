import kr.codesquad.MachineLotto;
import kr.codesquad.UserConsole;
import kr.codesquad.exception.CustomException;
import kr.codesquad.utils.Utility;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class MachineLottoTest {

    UserConsole userConsole = new UserConsole();
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

    @DisplayName("구매한 자동 로또 개수가 정상적으로 저장되는지")
    @Test
    void checkAutoLottoCount() {
        int amountOfMoney = 16500;
        int manualLottoCnt = 3;
        MachineLotto machineLotto = new MachineLotto(this.userConsole);
        Integer testedVal = machineLotto.getLottoCnt(amountOfMoney,manualLottoCnt);
        Assertions.assertThat(testedVal.equals(13));
    }

}
