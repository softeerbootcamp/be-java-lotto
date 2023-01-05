package kr.codesquad;

import kr.codesquad.utils.Utility;

import java.util.ArrayList;

public class LastLotto {
    private ArrayList<Integer> lastLotto; //저번 주 당첨 번호
    private UserConsole userConsole;

    public LastLotto(UserConsole userConsole){

        this.lastLotto = new ArrayList<>();
        this.userConsole = userConsole;
    }

    public ArrayList<Integer> getLastLotto(){
        System.out.println("지난 주 로또 당첨 번호를 입력해주세요.");
        String inputNumbers = userConsole.enter6NumbersByString();
        this.lastLotto = Utility.getListFromInputBySplit(inputNumbers);
        return this.lastLotto;
    }
}
