package kr.codesquad.UI;

import kr.codesquad.InputManager.AwtInputHandler;
import kr.codesquad.InputManager.UserInputHandler;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
// importing Java AWT class


// class AWTExample2 directly creates instance of Frame class
class SingleInputPanel extends Panel implements CustomPanel{

    UserInputHandler inputHandler;
    // initializing using constructor

    private Label errLabel;
    private Label instLabel;
    private String instruction;
    private TextField txt;
    private Button btn;
    SingleInputPanel(String instruction, ActionListener act) {
        super();
        setSize(200,360);
        setLayout(null);
        setElements();
        inputHandler = new AwtInputHandler(btn, txt, null, errLabel);
        this.instruction = instruction;
        btn.addActionListener(act);
    }

    private void setElements(){
        errLabel = new Label();
        instLabel = new Label(instruction);
        txt = new TextField();
        btn = new Button("확인");

        errLabel.setBounds(30, 80, 140, 30);
        instLabel.setBounds(30, 130, 140, 30);
        txt.setBounds(10, 160, 180, 30);
        btn.setBounds(45, 200, 110, 30);

        add(instLabel);
        add(txt);
        add(btn);
    }

    @Override
    public UserInputHandler getUserInputHandler(){
        return inputHandler;
    }
}