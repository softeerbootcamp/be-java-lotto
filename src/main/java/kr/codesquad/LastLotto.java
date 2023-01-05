package kr.codesquad;

import kr.codesquad.exception.CustomException;
import kr.codesquad.exception.ErrorCode;

import java.util.ArrayList;
import java.util.Scanner;

public class LastLotto {
    private ArrayList<Integer> lastLotto; //저번 주 당첨 번호

    public LastLotto(){
        this.lastLotto = new ArrayList<>();
    }

    public ArrayList<Integer> getLastLotto(){
        System.out.println("당첨 번호를 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        String inputNumbers = sc.nextLine();
        if(inputNumbers.split(", ").length != 6) throw new CustomException(ErrorCode.ILLEGAL_LOTTO_NUM_COUNT);
        for(String input : inputNumbers.split(", ")){
            this.lastLotto.add(java.lang.Integer.valueOf(input));
        }
        return this.lastLotto;
    }
}
