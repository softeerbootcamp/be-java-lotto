import kr.codesquad.model.UserInfo;
import kr.codesquad.view.UserConsole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserConsoleTest {

    private UserConsole userConsole;
    private UserInfo user;
    private ByteArrayOutputStream out;

    @BeforeEach
    void testSetUp() {
        user = new UserInfo();
        userConsole = new UserConsole(user);
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }


    @DisplayName("구입 금액 입력 테스트 - 정상 동작")
    @Test
    void enterPurchasePriceTest() {

        //given
        int purchasePrice = 10000; //구입 금액
        InputStream in = new ByteArrayInputStream(String.valueOf(purchasePrice).getBytes());
        System.setIn(in);

        //when
        int returnedNum = userConsole.enterPurchasePrice();

        //then
        assertEquals(purchasePrice, returnedNum);
    }

/*    @DisplayName("구입 금액 입력 테스트 - 정수형으로 입력하지 않을 경우")
    @Test
    void enterPurchasePrice_NoInt_Test() {

        //given
        String purchasePrice = "100"; //구입 금액
        InputStream in = new ByteArrayInputStream(purchasePrice.getBytes());
        System.setIn(in);

        //when
//        assertThrows()
        int returnedNum = userConsole.enterPurchasePrice();

        //then
        assertEquals(purchasePrice, returnedNum);
    } */

    @DisplayName("수동 로또 구매 수 입력 테스트 - 정상 동작")
    @Test
    void enterSudongLottoNumberTest(){

        //given
        int numOfSudong = 4; //수동 로또 구매 수
        InputStream in = new ByteArrayInputStream(String.valueOf(numOfSudong).getBytes());
        System.setIn(in);

        //when
        int returnedNum = userConsole.enterSudongLottoNumber();

        //then
        assertEquals(numOfSudong, returnedNum);
    }

    @DisplayName("수동 로또 리스트 입력 테스트 - 정상 동작")
    @Test
    void enterSudongLottoListTest(){

        //given
        String lottoList = "1,2,3,4,5,6";
        InputStream in = new ByteArrayInputStream(lottoList.getBytes());
        System.setIn(in);

        //when
        String returnedList = userConsole.enterSudongLottoList();

        //then
        assertEquals(lottoList, returnedList);
    }

    @DisplayName("당첨 번호 입력 테스트 - 정상 동작")
    @Test
    void enterResultList(){

        //given
        String resultList = "1,2,3,4,5,6";
        InputStream in = new ByteArrayInputStream(resultList.getBytes());
        System.setIn(in);
        //when
        String returnedList = userConsole.enterResultList();

        //then
        assertEquals(resultList, returnedList);
    }

    @DisplayName("보너스볼 입력 테스트 - 정상 동작")
    @Test
    void enterBonusNumTest(){

        //given
        int bonus = 3;
        InputStream in = new ByteArrayInputStream(String.valueOf(bonus).getBytes());
        System.setIn(in);
        //when
        int returnedBonus = userConsole.enterBonusNum();
        //then
        assertEquals(returnedBonus, bonus);
    }

}
