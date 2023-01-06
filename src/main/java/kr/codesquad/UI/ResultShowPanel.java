package kr.codesquad.UI;

import kr.codesquad.InputManager.AwtInputHandler;
import kr.codesquad.InputManager.UserInputHandler;

import java.awt.*;
import java.awt.event.ActionListener;

public class ResultShowPanel extends CustomPanel {
    private Label errLabel;
    private TextArea resultArea;
    private String instruction;
    private TextField txt;
    private Button btn;
    public ResultShowPanel(String message, ActionListener act){
        super();
        System.out.println(message);
        setSize(400,360);
        setLayout(null);
        this.instruction = message;
        setElements();
        btn.addActionListener(act);
    }

    private void setElements(){
        errLabel = new Label();
        resultArea = new TextArea(instruction);
        btn = new Button("확인");

        errLabel.setBounds(130, 20, 140, 30);
        resultArea.setBounds(55, 55, 290, 215);
        btn.setBounds(137, 280, 125, 30);

        errLabel.setAlignment(Label.CENTER);

        add(errLabel);
        add(resultArea);
        add(btn);
    }

    @Override
    public UserInputHandler getUserInputHandler() {
        return new AwtInputHandler(btn, txt, null, errLabel);
    }
}
