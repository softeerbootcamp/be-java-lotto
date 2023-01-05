import kr.codesquad.exception.InputFormatException;
import kr.codesquad.exception.InputRangeException;
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

    //테스트 환경 세팅
    @BeforeEach
    void testSetUp() {
        user = new UserInfo();
        userConsole = new UserConsole(user);
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }


    //인풋 스트림 설정
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

    @DisplayName("구입 금액 입력 테스트 - 정수형으로 입력하지 않을 경우")
    @Test
    void enterPurchasePrice_NoInt_Test() {

        //given
        String purchasePrice = "hello"; //구입 금액
        InputStream in = new ByteArrayInputStream(purchasePrice.getBytes());
        System.setIn(in);

        //then
        assertThrows(InputFormatException.class, ()->userConsole.enterPurchasePrice());

    }

    @DisplayName("구입 금액 입력 테스트 - 범위를 초과한 입력")
    @Test
    void enterPurchasePrice_OutOfPossibleRange_Test() {

        //given
        int purchasePrice = -1234; //구입 금액
        InputStream in = new ByteArrayInputStream(String.valueOf(purchasePrice).getBytes());
        System.setIn(in);

        //then
        assertThrows(InputRangeException.class, ()->userConsole.enterPurchasePrice());

    }

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

    @DisplayName("수동 로또 구매 수 입력 테스트 - 정수형이 아닐 경우")
    @Test
    void enterSudongLottoNumberTest_NoInt(){

        //given
        String numOfSudong = "hehe"; //수동 로또 구매 수
        InputStream in = new ByteArrayInputStream(numOfSudong.getBytes());
        System.setIn(in);

        //then
        assertThrows(InputFormatException.class, ()->userConsole.enterSudongLottoNumber());
    }

    @DisplayName("수동 로또 구매 수 입력 테스트 - 음수 입력 시")
    @Test
    void enterSudongLottoNumberTest_EnterMinus(){

        //given
        int numOfSudong = -123; //수동 로또 구매 수
        InputStream in = new ByteArrayInputStream(String.valueOf(numOfSudong).getBytes());
        System.setIn(in);

        //then
        assertThrows(InputRangeException.class, ()->userConsole.enterSudongLottoNumber());
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

    @DisplayName("보너스볼 입력 테스트 - 정수형이 아닐 경우")
    @Test
    void enterBonusNumTest_NoInt(){

        //given
        String bonus = "hello";
        InputStream in = new ByteArrayInputStream(String.valueOf(bonus).getBytes());
        System.setIn(in);

        //then
        assertThrows(InputFormatException.class, ()-> userConsole.enterBonusNum());

    }

    @DisplayName("보너스볼 입력 테스트 - 유효 로또 번호가 아닐 경우")
    @Test
    void enterBonusNumTest_NoPossibleNumber(){

        //given
        int bonus = 456;
        InputStream in = new ByteArrayInputStream(String.valueOf(bonus).getBytes());
        System.setIn(in);

        //then
        assertThrows(InputRangeException.class, ()-> userConsole.enterBonusNum());
    }
}
