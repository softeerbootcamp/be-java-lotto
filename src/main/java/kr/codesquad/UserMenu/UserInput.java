package kr.codesquad.UserMenu;

import kr.codesquad.CustomException;
import kr.codesquad.EmptyLotto;
import kr.codesquad.InputHandler;
import kr.codesquad.Utility;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    private InputHandler inputHandler;
    private UserLotto userLotto;
    private Utility utility;

    public UserInput() {
        inputHandler = new InputHandler();
        userLotto = new UserLotto();
        utility = new Utility();
    }

    public int userHowManyLotto() throws CustomException {
        System.out.println("구입 금액을 입력해 주세요.");
        return inputHandler.getIntegerInput() / 1000;
    }

    public int userHowManyManual() throws CustomException {
        System.out.printf("수동으로 구매할 로또 수를 입력해 주세요\n");
        return inputHandler.getIntegerInput();
    }

    public List<EmptyLotto> userManualInput() throws CustomException {
        System.out.printf("수동으로 구매할 번호를 입력해 주세요\n");
        List<EmptyLotto> userLottoList = new ArrayList<>();
        for (int i = 0; i < userLotto.getUserManualLottoCount(); i++) {
            EmptyLotto emptyLotto = new EmptyLotto(
                    utility.transStringToIntegerList(inputHandler.getStringInput()));
            userLottoList.add(emptyLotto);
        }
        return userLottoList;
    }


}
