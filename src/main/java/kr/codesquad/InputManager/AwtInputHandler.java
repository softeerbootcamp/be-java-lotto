package kr.codesquad.InputManager;

import kr.codesquad.Utility;

import java.awt.*;
import java.util.List;

public class AwtInputHandler implements UserInputHandler{
    private Button submit;
    private List<TextField> textFields;

    public AwtInputHandler (Button submit, List<TextField> textFields){
        this.submit = submit;
        this.textFields  = textFields;
    }
    @Override
    public int getMoney() {
        return Utility.parseIntWithRange(textFields.get(0).getText(), 1, 45);
    }

    @Override
    public List<Integer> getSixLottoNumber() {
        return Utility.str2IntListWithRange(textFields.get(0).getText(), 1, 45);
    }

    @Override
    public int getBonusNumber(List<Integer> winningNumbers) {
        return 0;
    }

    @Override
    public int getManualLottoAmount(int max) {
        return 0;
    }
}
