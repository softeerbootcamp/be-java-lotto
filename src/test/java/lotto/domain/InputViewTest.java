package lotto.domain;

import kr.codesquad.view.InputView;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class InputViewTest extends IOTest{
    @Test
    public void inputMoney_MoneyisNotInteger_ExceptionThrown(){
        systemIn("hello\n");
        assertThrows(IllegalArgumentException.class, InputView::inputMoney);
    }
}
