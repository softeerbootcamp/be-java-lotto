import kr.codesquad.view.UserConsoleHandler;
import kr.codesquad.exception.InputCountException;
import kr.codesquad.exception.InputFormatException;
import kr.codesquad.model.UserInfo;
import org.junit.jupiter.api.*;

import java.io.*;

public class UserConsoleHandlerTest {

    private UserInfo user;
    private UserConsoleHandler userConsoleHandler;
    private OutputStream out;


    //테스트 환경 세팅
    @BeforeEach
    void testSetUp(){
        user = new UserInfo();
        userConsoleHandler = new UserConsoleHandler(user);
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    //인풋 스트림 설정
    protected void systemIn(String input){
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }


    @DisplayName("수동 구매 로직 테스트 - 이상한 형태로 입력 시")
    @Test
    void sudongLottoPurchase_InvalidFormat(){

        //given
        String lottoStr = "a,b,c,d,e,1";
        InputStream in = new ByteArrayInputStream(lottoStr.getBytes());
        System.setIn(in);

        //then
        Assertions.assertThrows(InputFormatException.class, ()-> userConsoleHandler.enterLottoList(1));

    }

    @DisplayName("수동 구매 로직 테스트 - 중복된 값 입력 시")
    @Test
    void sudongLottoPurchase_duplicatedVal(){

        //given
        String lottoStr = "1,1,2,3,4,5";
        InputStream in = new ByteArrayInputStream(lottoStr.getBytes());
        System.setIn(in);

        //then
        Assertions.assertThrows(InputCountException.class, ()-> userConsoleHandler.enterLottoList(1));

    }

    @DisplayName("수동 구매 로직 테스트 - 개수 초과 시")
    @Test
    void sudongLottoPurchase_moreThan6Nums(){

        //given
        String lottoStr = "1,2,3,4,5,6,7";
        InputStream in = new ByteArrayInputStream(lottoStr.getBytes());
        System.setIn(in);

        //then
        Assertions.assertThrows(InputCountException.class, ()-> userConsoleHandler.enterLottoList(1));

    }


}
