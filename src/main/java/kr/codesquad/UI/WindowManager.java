package kr.codesquad.UI;

import kr.codesquad.VisualLottoGame;

import java.awt.*;

public class WindowManager extends Frame{

    private Panel currentPanel;

    public WindowManager (){
        super();
        setSize(200,360);
        setLayout(null);
        setVisible(true);
        setTitle("로또 시뮬레이터");
    }

    public void setMoneyPanel(){
        currentPanel = new SingleInputPanel("구매 금액을 입력해 주세요.", e->VisualLottoGame.getVisualLottoGame().getMoney());
        add(currentPanel);

        currentPanel.setVisible(true);
    }

    public void setAmountOfManualLottoPanel(int maxAmount){
        setPanel(
                new SingleInputPanel(
                        String.format("수동 개수를 입력해 주세요(최대 %d개)", maxAmount),
                        e->VisualLottoGame.getVisualLottoGame().getAmountOfManualLotto()));
    }

    public void setOneManualLottoPanel(int nManualLeft) {
        setPanel(
                new SingleInputPanel(
                        String.format("구매 번호를 입력해 주세요.\n(남은 수동 개수 %d개)", nManualLeft),
                        e->VisualLottoGame.getVisualLottoGame().buyOneManualLotto()));
    }
    private void setPanel(Panel nextPanel){
        currentPanel.setVisible(false);
        remove(currentPanel);
        currentPanel = nextPanel;
        add(currentPanel);
        nextPanel.setVisible(true);
    }

    public void setPurchasedLottoPanel() {
        //TODO : 구매한 로또 판낼 작성
    }

    public void setLottoResultPanel() {
        //TODO : 로또 결과 판낼 작성
    }
}
