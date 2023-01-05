package kr.codesquad.UI;

import java.awt.*;
// importing Java AWT class


// class AWTExample2 directly creates instance of Frame class
class MoneyInputView extends Frame{

    // initializing using constructor
    MoneyInputView() {
        super();
        setSize(200,360);
        setTitle("로또 시뮬레이터");
        setLayout(null);
        setVisible(true);
    }

    private void setElements(){
        Label l = new Label("구매금액을 입력해 주세요");
        TextField t = new TextField();
        Button b = new Button("확인");

        l.setBounds(30, 130, 140, 30);
        t.setBounds(10, 160, 180, 30);
        b.setBounds(45, 200, 110, 30);

        add(b);
        add(l);
        add(t);
    }

}