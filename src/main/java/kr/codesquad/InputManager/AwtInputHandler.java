package kr.codesquad.InputManager;

import kr.codesquad.Exceptions.CustomException;
import kr.codesquad.Utility;
import kr.codesquad.VisualLottoGame;

import java.awt.*;
import java.util.List;

public class AwtInputHandler implements UserInputHandler{
    private Label errLabel;
    private Button submit;
    private TextField textField;
    private TextField bonus;

    public AwtInputHandler (Button submit, TextField textField, TextField bonus, Label errLabel){
        this.submit = submit;
        this.textField  = textField;
        this.errLabel = errLabel;
        this.bonus = bonus;
    }
    @Override
    public int getMoney() {
        try {
            int money = Utility.parseIntWithRange(textField.getText(), 0, Integer.MAX_VALUE);
            return money;
        }
        catch(Exception e){
            errLabel.setText(e.getMessage());
        }
        return 0;
    }

    @Override
    public List<Integer> getSixLottoNumber() {
        return Utility.str2IntListWithRange(textField.getText(), 1, 45);
    }

    @Override
    public int getBonusNumber(List<Integer> winningNumbers) {
        int bonus = Utility.parseIntWithRange(this.bonus.getText(),1, 45);
        if (winningNumbers.contains(bonus)) {
            throw new CustomException("Bonus와 winningNumbers 중복발생");
        }
        return bonus;
    }

    @Override
    public int getManualLottoAmount(int max) {
        return Utility.parseIntWithRange(textField.getText(), 0, max);
    }
}
