package kr.codesquad.InputManager;

import java.util.List;

public interface UserInputHandler {

    int getMoney();

    List<Integer> getSixLottoNumber();

    int getBonusNumber(List<Integer> winningNumbers);

    int getManualLottoAmount(int max);
}
