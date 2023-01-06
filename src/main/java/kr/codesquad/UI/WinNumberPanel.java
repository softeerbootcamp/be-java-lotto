package kr.codesquad.UI;

import kr.codesquad.InputManager.AwtInputHandler;
import kr.codesquad.InputManager.UserInputHandler;

import java.awt.*;
import java.awt.event.ActionListener;

public class WinNumberPanel extends CustomPanel{

    private UserInputHandler inputHandler;
    // initializing using constructor

    private Label errLabel;
    private Label instLabel;
    private String instruction;
    private TextField txt;
    private TextField bonus;
    private Button btn;
    public WinNumberPanel( ActionListener act) {
        super();
        setSize(200,360);
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
        bonus = new TextField();
        btn = new Button("확인");


        errLabel.setBounds(30, 80, 140, 30);
        instLabel.setBounds(30, 130, 100, 30);
        txt.setBounds(10, 160, 150, 30);
        bonus.setBounds(140, 160, 30, 30);
        btn.setBounds(45, 200, 110, 30);

        add(errLabel);
        add(instLabel);
        add(bonus);
        add(txt);
        add(btn);
    }

    @Override
    public UserInputHandler getUserInputHandler() {
        return new AwtInputHandler(btn, txt, bonus, errLabel);
    }
}
