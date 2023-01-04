package kr.codesquad.entities.lottoImpl;

import kr.codesquad.templates.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ResultLotto extends Lotto {

    private int bonusNum;


    //인풋 스트링을 정수형 배열로 변환
    public ArrayList<Integer> parseString(String str){
        List<String> split = Arrays.asList(str.split(","));
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        if(split.size() != 6)
            throw new RuntimeException("올바르지 않은 입력입니다");
        split.forEach(item->tempList.add(Integer.parseInt(item)));
        return tempList;
    }

    //유저에게 인풋을 받아 이를 로또 리스트에 저장
    public void enterResultNumbers(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        Scanner scan = new Scanner(System.in);
        String numStr = scan.nextLine();
        addLotto(parseString(numStr));
    }
    //보너스 번호 입력
    public void enterBonusNum(){
        System.out.println("보너스볼을 입력해 주세요.");
        Scanner scan = new Scanner(System.in);
        int givenBonusNum = scan.nextInt();
        this.bonusNum = givenBonusNum;
    }

    public int getBonusNum(){
        return bonusNum;
    }

}
