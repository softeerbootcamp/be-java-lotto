package kr.codesquad.UserMenu;

import kr.codesquad.CustomException;
import kr.codesquad.InputHandler;

public class UserInput extends UserLotto {
    private InputHandler inputHandler;

    public int userHowManyLotto() throws CustomException {
        System.out.println("구입 금액을 입력해 주세요.");
        return inputHandler.getIntegerInput()/1000;
    }
    public int userHowManyManual() throws CustomException {
        System.out.printf("수동으로 구매할 로또 수를 입력해 주세요\n");
        int manualCount = inputHandler.getIntegerInput();
        if(manualCount>getUserAllLottoCount()){
            throw new CustomException("수동으로 구매하려는 갯수가 총 갯수보다 많습니다!!");
        }
        return inputHandler.getIntegerInput();
    }
}
