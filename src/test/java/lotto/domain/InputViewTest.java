package lotto.domain;

import kr.codesquad.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class InputViewTest extends IOTest{
    @Test
    public void inputMoney_Moneyis2000_Return2000(){
        systemIn("2000");
        assertThat(InputView.inputMoney()).isEqualTo(2000);
    }

    @Test
    public void inputMoney_MoneyisNotInteger_ExceptionThrown(){
        systemIn("a");
        assertThrows(IllegalArgumentException.class, InputView::inputMoney);
    }
}
