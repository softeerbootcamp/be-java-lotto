package kr.codesquad.UI.Panels;

import kr.codesquad.InputManager.AwtInputHandler;
import kr.codesquad.InputManager.UserInputHandler;
import kr.codesquad.UI.Panels.CustomPanel;

import java.awt.*;
import java.awt.event.ActionListener;


public class SingleInputPanel extends CustomPanel {

    UserInputHandler inputHandler;
    private Label errLabel;
    private Label instLabel;
    private String instruction;
    private TextField txt;
    private Button btn;
    public SingleInputPanel(String instruction, ActionListener act) {
        super();
        setSize(400,360);
        setLayout(null);
        this.instruction = instruction;
        setElements();
        btn.addActionListener(act);
        inputHandler = new AwtInputHandler(btn, txt, null, errLabel);
    }

    private void setElements(){
        errLabel = new Label();
        instLabel = new Label(instruction);
        txt = new TextField();
        btn = new Button("확인");

        errLabel.setBounds(0, 100, 400, 30);
        instLabel.setBounds(0, 135, 400, 30);
        txt.setBounds(80, 170, 240, 30);
        btn.setBounds(125, 230, 150, 30);

        errLabel.setAlignment(Label.CENTER);
        instLabel.setAlignment(Label.CENTER);

        add(errLabel);
        add(instLabel);
        add(txt);
        add(btn);
    }

    @Override
    public UserInputHandler getUserInputHandler(){
        return inputHandler;
    }
}