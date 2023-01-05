package kr.codesquad.UI;

import java.awt.*;

public class WindowManager extends Frame{

    private Panel currentPanel;

    public WindowManager (){
        super();
        setSize(200,360);
        setLayout(null);
        setVisible(true);
        setTitle("로또 시뮬레이터");

        currentPanel = new MoneyInputView(this);
        add(currentPanel);
        currentPanel.setVisible(true);
    }

    public void setPanel(Panel nextPanel){
        currentPanel.setVisible(false);
        remove(currentPanel);
        currentPanel = nextPanel;
        add(currentPanel);
        nextPanel.setVisible(true);
    }

    public static void main(String[] args){
        WindowManager manager = new WindowManager();
    }
}
