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
        setSize(400,360);
        setLayout(null);
        this.instructionStr = inst;
        this.txtAreaStr = message;
        setElements();
        btn.addActionListener(act);
    }

    private void setElements(){
        instLabel = new Label(instructionStr);
        resultArea = new TextArea(txtAreaStr);
        btn = new Button("확인");

        instLabel.setBounds(130, 20, 140, 30);
        resultArea.setBounds(55, 55, 290, 215);
        btn.setBounds(137, 280, 125, 30);

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
