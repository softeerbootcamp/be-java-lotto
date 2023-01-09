package kr.codesquad.UI;

import kr.codesquad.InputManager.UserInputHandler;
import kr.codesquad.Lotto.Lotto;
import kr.codesquad.UI.Panels.CustomPanel;
import kr.codesquad.UI.Panels.ResultShowPanel;
import kr.codesquad.UI.Panels.SingleInputPanel;
import kr.codesquad.UI.Panels.WinNumberPanel;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.*;

public class WindowManager extends Frame {

    private CustomPanel currentPanel;

    public WindowManager() {
        super();
        setSize(400, 360);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setTitle("로또 시뮬레이터");
    }

    public void setMoneyPanel(ActionListener act) {
        currentPanel = new SingleInputPanel("구매 금액을 입력해 주세요.", act);
        add(currentPanel);
        currentPanel.setVisible(true);
    }

    public void setAmountOfManualLottoPanel(int maxAmount, ActionListener act) {
        setPanel(
                new SingleInputPanel(String.format("수동 개수를 입력해 주세요(최대 %d개)", maxAmount), act)
        );
    }

    public void setOneManualLottoPanel(int nManualLeft, ActionListener act) {
        setPanel(
                new SingleInputPanel(
                        String.format("구매 번호를 입력해 주세요.\n(남은 수동 개수 %d개)", nManualLeft),
                        act)
        );
    }

    public void setPurchasedLottoPanel(List<Lotto> lottos, ActionListener act) {
        StringBuilder result = new StringBuilder();
        for (Lotto lotto : lottos) {
            result.append(lotto).append("\n");
        }
        setPanel(
                new ResultShowPanel("구매하신 로또 번호는 다음과 같습니다.", result.toString(), act)
        );
    }

    public void setWinLottoPanel(ActionListener act) {
        setPanel(
                new WinNumberPanel(act)
        );
    }

    public void setResultLottoPanel(String result, ActionListener act) {
        setPanel(
                new ResultShowPanel("로또 당첨 결과 확인", result, act)
        );
    }

    private void setPanel(CustomPanel nextPanel) {
        currentPanel.setVisible(false);
        remove(currentPanel);
        currentPanel = nextPanel;
        add(currentPanel);
        nextPanel.setVisible(true);
    }

    public UserInputHandler getInputHandler() {
        return currentPanel.getUserInputHandler();
    }

    public void close() {
        this.setVisible(false);
    }
}
