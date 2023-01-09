package kr.codesquad.user;

import kr.codesquad.CustomException;
import kr.codesquad.lottoManager.LottoPaper;
import kr.codesquad.utility.InputHandler;
import kr.codesquad.utility.Utility;

import java.util.ArrayList;
import java.util.List;

public class UserInput extends CustomException{
    private InputHandler inputHandler;
    private Utility utility;
    public static UserInput USERINPUT = new UserInput();
    public UserInput() {

        inputHandler = new InputHandler();
        utility = new Utility();
    }
    public int userHowManyLotto() {
        System.out.println("구입 금액을 입력해 주세요.");
        int lottoCnt = inputHandler.getIntegerInput() / 1000;
        return lottoCnt;
    }

    public int userHowManyManual() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요");
        return inputHandler.getIntegerInput();
    }

    public void userInputManual(UserLotto userLotto) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요");
        for (int i = 0; i < userLotto.getUserManualLottoCount(); i++) {
            LottoPaper emptyLotto = new LottoPaper(
                    utility.transManualInputToLottoList(inputHandler.getStringInput()));
            userLotto.getUserLottoList().add(emptyLotto);
        }

    }

    public List<Integer> userInputJackpotNum() {
        System.out.printf("당첨 번호를 입력해 주세요.\n");
        String[] userInputString = inputHandler.getStringInput().split(",");
        numberCountSix(userInputString);
        List<Integer> userInputJackpotNum = new ArrayList<>();
        for (String num : userInputString) {
            userInputJackpotNum.add(Integer.parseInt(num));
        }
        return userInputJackpotNum;
    }

    public int userSetBonusNum()  {
        System.out.printf("보너스 번호를 입력해 주세요.\n");
        int bonus = inputHandler.getIntegerInput();
        return bonus;
    }
}
