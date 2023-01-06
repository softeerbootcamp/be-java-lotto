package kr.codesquad.User;

import kr.codesquad.CustomException;
import kr.codesquad.LottoManager.EmptyLotto;
import kr.codesquad.Utility.InputHandler;
import kr.codesquad.Utility.Utility;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    private InputHandler inputHandler;
    private Utility utility;
    public static UserInput USERINPUT = new UserInput();

    public UserInput() {
        inputHandler = new InputHandler();
        utility = new Utility();
    }
    public static UserInput getUSERINPUT() {
        return USERINPUT;
    }
    public int userHowManyLotto() throws CustomException {
        System.out.println("구입 금액을 입력해 주세요.");
        int lottoCnt = inputHandler.getIntegerInput() / 1000;
        if(lottoCnt%1000!=0){
            throw new CustomException("1000원 단위로 입력해 주세요");
        }
        return lottoCnt;
    }

    public int userHowManyManual() throws CustomException {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요");
        return inputHandler.getIntegerInput();
    }

    public void userInputManual(UserLotto userLotto) throws CustomException {
        System.out.println("수동으로 구매할 번호를 입력해 주세요");
        for (int i = 0; i < userLotto.getUserManualLottoCount(); i++) {
            EmptyLotto emptyLotto = new EmptyLotto(
                    utility.transStringToIntegerList(inputHandler.getStringInput()));
            userLotto.getUserLottoList().add(emptyLotto);
        }
    }

    public List<Integer> userInputJackpotNum() throws CustomException {
        System.out.printf("당첨 번호를 입력해 주세요.\n");
        String[] userInputString = inputHandler.getStringInput().split(",");
        List<Integer> userInputJackpotNum = new ArrayList<>();
        for (String num : userInputString) {
            userInputJackpotNum.add(Integer.parseInt(num));
        }
        return userInputJackpotNum;
    }

    public int userSetBonusNum() throws CustomException {
        System.out.printf("보너스 번호를 입력해 주세요.\n");
        int bonus = inputHandler.getIntegerInput();

        return bonus;
    }
}
