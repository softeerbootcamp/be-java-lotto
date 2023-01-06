package kr.codesquad.UI.Panels;

import kr.codesquad.InputManager.AwtInputHandler;
import kr.codesquad.InputManager.UserInputHandler;
import kr.codesquad.UI.Panels.CustomPanel;

import java.awt.*;
import java.awt.event.ActionListener;

public class WinNumberPanel extends CustomPanel {

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
        setSize(400,360);
        setLayout(null);
        setElements();
        btn.addActionListener(act);
        inputHandler = new AwtInputHandler(btn, txt, null, errLabel);
    }

    private void setElements(){
        errLabel = new Label();
        instLabel = new Label("당첨번호를 입력해 주세요.");
        txt = new TextField();
        bonus = new TextField();
        btn = new Button("확인");


        errLabel.setBounds(0, 100, 400, 30);
        instLabel.setBounds(100, 135, 200, 30);
        txt.setBounds(80, 170, 200, 30);
        bonus.setBounds(300, 170, 30, 30);
        btn.setBounds(125, 230, 150, 30);


        errLabel.setAlignment(Label.CENTER);
        instLabel.setAlignment(Label.CENTER);

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
