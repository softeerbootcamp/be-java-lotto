package kr.codesquad.UI;

import kr.codesquad.InputManager.UserInputHandler;
import kr.codesquad.Lotto.Lotto;
import kr.codesquad.VisualLottoGame;
import java.util.List;
import java.awt.*;

public class WindowManager extends Frame{

    private CustomPanel currentPanel;

    public WindowManager (){
        super();
        setSize(400,360);
        setLayout(null);
        setVisible(true);
        setTitle("로또 시뮬레이터");
    }

    public void setMoneyPanel(){
        currentPanel = new SingleInputPanel(
                "구매 금액을 입력해 주세요.",
                e->VisualLottoGame.getVisualLottoGame().getMoney());
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
    public void setPurchasedLottoPanel(List<Lotto> lottos) {
        StringBuilder result= new StringBuilder();
        for(Lotto lotto : lottos){
            result.append(lotto).append("\n");
        }
        System.out.println(result);
        setPanel(
                new ResultShowPanel(
                        result.toString(),
                        e -> VisualLottoGame.getVisualLottoGame().showGeneratedLotto())
        );
    }

    public void setWinLottoPanel() {
        setPanel(
                new WinNumberPanel(
                        e->VisualLottoGame.getVisualLottoGame().getWiningLotto())
        );
        //TODO : 승리 로또 입력 판넬 작성
    }

    public void setResultLottoPanel(String result){
        //TODO : 로또 결과 판낼 작성
        setPanel(
                new ResultShowPanel(
                        result,
                        e -> VisualLottoGame.getVisualLottoGame().haltAll())
        );
    }

    private void setPanel(CustomPanel nextPanel){
        currentPanel.setVisible(false);
        remove(currentPanel);
        currentPanel = nextPanel;
        add(currentPanel);
        nextPanel.setVisible(true);
    }

    public UserInputHandler getInputHandler(){
        return currentPanel.getUserInputHandler();
    }
}
