import kr.codesquad.LastLotto;
import kr.codesquad.UserConsole;
import kr.codesquad.exception.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import org.assertj.core.api.Assertions;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class LastLottoTest {

    private UserConsole userConsole = new UserConsole();

//    @BeforeEach
//    void init(){
//        this.userConsole = new UserConsole();
//    }

    @DisplayName("정상 입력일 때 숫자 배열이 잘 저장되는지")
    @Test
    void createLotto(){
        String inputNumbers = "1, 2, 3, 4, 5, 6";
        ArrayList<Integer> expectedList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        LastLotto lastLotto = new LastLotto(this.userConsole,inputNumbers);
        ArrayList<Integer> myList = lastLotto.getLastLottoList();
        Assertions.assertThat(myList.equals(expectedList));
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize(){
        String inputNumbers = "1, 2, 3, 4, 5, 6, 7";
        //assertThatThrownBy -> 예외가 발생해야 테스트 통과됨
        assertThatThrownBy(() -> new LastLotto(this.userConsole,inputNumbers))
                .isInstanceOf(CustomException.class);
    }

    @DisplayName("로또 번호의 수가 6개보다 적으면 예외가 발생한다.")
    @Test
    void createLottoBySmallSize(){
        String inputNumbers = "1, 2, 3, 4, 5";
        //assertThatThrownBy -> 예외가 발생해야 테스트 통과됨
        assertThatThrownBy(() -> new LastLotto(this.userConsole,inputNumbers))
                .isInstanceOf(CustomException.class);
    }

    @DisplayName("로또 번호의 개수가 6개는 맞기만 숫자 범위가 1이상 45이하가 아닐 때")
    @Test
    void createLottoByNotRangedNumber(){
        String inputNumbers = "1, 2, 3, 4, 51, 6";
        //assertThatThrownBy -> 예외가 발생해야 테스트 통과됨
        assertThatThrownBy(() -> new LastLotto(this.userConsole,inputNumbers))
                .isInstanceOf(CustomException.class);
    }

    @DisplayName("로또 번호의 개수가 6개이고, 구성 숫자의 범위도 맞지만 중복이 될 때")
    @Test
    void createLottoByDuplicatedNumber(){
        String inputNumbers = "1, 2, 3, 4, 4, 6";
        //assertThatThrownBy -> 예외가 발생해야 테스트 통과됨
        assertThatThrownBy(() -> new LastLotto(this.userConsole,inputNumbers))
                .isInstanceOf(CustomException.class);
    }
}
