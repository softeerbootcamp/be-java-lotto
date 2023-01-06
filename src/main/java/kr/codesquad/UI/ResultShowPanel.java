package kr.codesquad.UI;

import kr.codesquad.InputManager.AwtInputHandler;
import kr.codesquad.InputManager.UserInputHandler;

import java.awt.*;
import java.awt.event.ActionListener;

public class ResultShowPanel extends CustomPanel {
    private Label errLabel;
    private TextArea instLabel;
    private String instruction;
    private TextField txt;
    private Button btn;
    public ResultShowPanel(String message, ActionListener act){
        super();
        System.out.println(message);
        setSize(200,360);
        setLayout(null);
        this.instruction = message;
        setElements();
        btn.addActionListener(act);
    }

    private void setElements(){
        errLabel = new Label();
        instLabel = new TextArea(instruction);
        btn = new Button("확인");

        errLabel.setBounds(30, 20, 180, 30);
        instLabel.setBounds(30, 50, 180, 100);
        btn.setBounds(45, 200, 110, 30);

        add(errLabel);
        add(instLabel);
        add(btn);
    }

    @Override
    public UserInputHandler getUserInputHandler() {
        return new AwtInputHandler(btn, txt, null, errLabel);
    }
}
