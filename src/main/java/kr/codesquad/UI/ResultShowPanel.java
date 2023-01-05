package kr.codesquad.UI;

import kr.codesquad.InputManager.AwtInputHandler;
import kr.codesquad.InputManager.UserInputHandler;

import java.awt.*;
import java.awt.event.ActionListener;

public class ResultShowPanel extends CustomPanel {
    private Label errLabel;
    private Label instLabel;
    private String instruction;
    private TextField txt;
    private Button btn;
    public ResultShowPanel(String message, ActionListener act){
        super();
        setSize(200,360);
        setLayout(null);
        setElements();
        this.instruction = message;
        btn.addActionListener(act);
    }

    private void setElements(){
        errLabel = new Label();
        instLabel = new Label(instruction);
        txt = new TextField();
        btn = new Button("확인");

        instLabel.setBounds(30, 50, 180, 215);
        txt.setBounds(10, 160, 180, 30);
        btn.setBounds(45, 200, 110, 30);

        add(instLabel);
        add(txt);
        add(btn);
    }

    @Override
    public UserInputHandler getUserInputHandler() {
        return new AwtInputHandler(btn, txt, null, errLabel);
    }
}
