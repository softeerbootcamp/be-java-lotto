package kr.codesquad.InputManager;

import kr.codesquad.Exceptions.CustomException;
import kr.codesquad.Utility;

import java.util.List;
import java.util.Scanner;

public class UserInputHandlerImpl implements UserInputHandler {

    private Scanner s1;

    public UserInputHandlerImpl() {
        s1 = new Scanner(System.in);
    }

    @Override
    public int getOneNumber(int lower_bound, int upper_bound) {
        String userInputStr = s1.nextLine();
        return Utility.parseIntWithRange(userInputStr, lower_bound, upper_bound);
    }

    @Override
    public int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = getOneNumber(0, Integer.MAX_VALUE);
        if (money % 1000 != 0)
            throw new CustomException("구입 금액은 1000의 배수여야 합니다.");
        return money;
    }

    @Override
    public List<Integer> getSixLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumber = Utility.stringToIntList(s1.nextLine());
        if (winningNumber.size() != 6)
            throw new CustomException("당첨 번호가 6개의 숫자가 아닙니다.");
        if (Utility.isDuplicated(winningNumber))
            throw new CustomException("당첨 번호에 중복된 숫자가 있습니다.");
        return winningNumber;
    }

    @Override
    public int getBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonus = getOneNumber(1, 45);
        if (winningNumbers.contains(bonus))
            throw new CustomException("보너스 숫자가 당첨번호에 포함되어 있습니다.");
        return bonus;
    }

    @Override
    public int getManualLottoAmount(int max) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return getOneNumber(0, max);
    }
}
