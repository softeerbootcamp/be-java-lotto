package kr.codesquad.InputManager;

import java.util.List;

public interface UserInputHandler {

    public int getMoney();

    public List<Integer> getSixLottoNumber();

    public int getBonusNumber(List<Integer> winningNumbers);

    public int getManualLottoAmount(int max);
}
