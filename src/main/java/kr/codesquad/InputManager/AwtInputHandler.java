package kr.codesquad.InputManager;

import kr.codesquad.Exceptions.CustomException;
import kr.codesquad.Utility;

import java.awt.*;
import java.util.List;

public class AwtInputHandler implements UserInputHandler {
    private final Label errLabel;
    private final TextField textField;
    private final TextField bonus;

    public AwtInputHandler(TextField textField, TextField bonus, Label errLabel) {
        this.textField = textField;
        this.errLabel = errLabel;
        this.bonus = bonus;
    }

    @Override
    public int getMoney() {
        try {
            int money = Utility.parseIntWithRange(textField.getText(), 0, Integer.MAX_VALUE);
            if (money % 1000 != 0) {
                throw new CustomException("1000단위로 돈을 입력해야 합니다.");
            }
            return money;
        } catch (Exception e) {
            errLabel.setText(e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Integer> getSixLottoNumber() {
        try {
            return Utility.str2IntListWithRange(textField.getText(), 1, 45);
        } catch (Exception e) {
            errLabel.setText(e.getMessage());
            throw e;
        }
    }

    @Override
    public int getBonusNumber(List<Integer> winningNumbers) {
        try {
            int bonus = Utility.parseIntWithRange(this.bonus.getText(), 1, 45);
            if (winningNumbers.contains(bonus)) {
                throw new CustomException("보너스와 당첨번호는 중복되면 안됩니다.");
            }
            return bonus;
        } catch (Exception e) {
            errLabel.setText(e.getMessage());
            throw e;
        }

    }

    @Override
    public int getManualLottoAmount(int max) {
        try {
            return Utility.parseIntWithRange(textField.getText(), 0, max);
        } catch (Exception e) {
            errLabel.setText(e.getMessage());
            throw e;
        }

    }
}
