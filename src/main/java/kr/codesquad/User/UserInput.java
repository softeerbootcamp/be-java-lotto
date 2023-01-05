package kr.codesquad.User;

import kr.codesquad.CustomException;
import kr.codesquad.LottoManager.EmptyLotto;
import kr.codesquad.InputHandler;
import kr.codesquad.Utility;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    private static InputHandler inputHandler = new InputHandler();
    private static Utility utility = new Utility();

    public UserInput() {

    }

    public int userHowManyLotto() throws CustomException {
        System.out.println("구입 금액을 입력해 주세요.");
        return inputHandler.getIntegerInput() / 1000;
    }

    public int userHowManyManual() throws CustomException {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요\n");
        return inputHandler.getIntegerInput();
    }

    public void userInputManual(UserLotto userLotto) throws CustomException {
        System.out.println("수동으로 구매할 번호를 입력해 주세요\n");
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

    public int userSetBonusNum(List<Integer> JACKPOT_NUM) throws CustomException {
        System.out.printf("보너스 번호를 입력해 주세요.\n");
        int bonus = inputHandler.getIntegerInput();
        if (JACKPOT_NUM.contains(bonus)) {
            throw new CustomException("보너스 번호는 원래 번호들과 중복돠어선 안된다.");
        }
        return bonus;
    }
}
