import kr.codesquad.exception.CustomException;
import kr.codesquad.exception.ErrorCode;
import kr.codesquad.utils.Utility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class UserLottoTest {

    //인풋 스트림 설정
    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    int getCnt(int amountOfMoney, int manualLottoCount){
        if(manualLottoCount*1000 > amountOfMoney) throw new CustomException(ErrorCode.MONEY_NOT_ENOUGH);
        return manualLottoCount;
    }

    //수동으로 구매할 로또 수 정상인지 확인
    @DisplayName("수동으로 구매할 로또 수 예외 처리 - 금액이 부족할 때")
    @Test
    void checkManualLottoCnt(){

        //given
        int amountOfMoney = 1000; //구입 금액
        int manualCnt = 3;

        //then
        assertThatThrownBy(() -> getCnt(amountOfMoney,manualCnt))
                .isInstanceOf(CustomException.class);
    }

    int checkDuplicate(List<Integer> lastLotto, int bonusBall){
        if(lastLotto.contains(bonusBall)) throw new CustomException(ErrorCode.NUMBER_ALREADY_EXIST);
        return bonusBall;
    }

    @DisplayName("기존 당첨 번호와 보너스 볼 중복 확인 테스트")
    @Test
    void checkManualLotto(){

        ArrayList<Integer> list = new ArrayList<>(List.of(1,2,3,4,5,6));
        //checkDuplicate(list,6);

        assertThatThrownBy(() -> checkDuplicate(list,6))
                .isInstanceOf(CustomException.class);

    }



}
