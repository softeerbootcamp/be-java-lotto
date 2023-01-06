package kr.codesquad.UI;

import kr.codesquad.InputManager.AwtInputHandler;
import kr.codesquad.InputManager.UserInputHandler;

import java.awt.*;
import java.awt.event.ActionListener;

public class ResultShowPanel extends CustomPanel {
    private Label instLabel;
    private TextArea resultArea;
    private String instructionStr;
    private String txtAreaStr;
    private Button btn;
    public ResultShowPanel(String inst, String message, ActionListener act){
        super();
        this.instructionStr = inst;
        this.txtAreaStr = message;
        setSize(400,360);
        setLayout(null);
        setElements();
        btn.addActionListener(act);
    }

    private void setElements(){
        instLabel = new Label(instructionStr);
        resultArea = new TextArea(txtAreaStr);
        btn = new Button("확인");

        instLabel.setBounds(0, 50, 400, 30);
        resultArea.setBounds(55, 85, 290, 215);
        btn.setBounds(137, 310, 125, 30);

        instLabel.setAlignment(Label.CENTER);

        add(instLabel);
        add(resultArea);
        add(btn);
    }

    @Override
    public UserInputHandler getUserInputHandler() {
        return new AwtInputHandler(btn, null, null, instLabel);
    }
}
