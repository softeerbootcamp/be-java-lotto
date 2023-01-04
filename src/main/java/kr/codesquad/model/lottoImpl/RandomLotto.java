package kr.codesquad.model.lottoImpl;

import kr.codesquad.templates.Lotto;

import java.util.ArrayList;
import java.util.Collections;

public class RandomLotto extends Lotto {

    private ArrayList<Integer> allNums = new ArrayList<Integer>();

    public RandomLotto(){
        generateAllNums();
    }

    //난수 생성 용 ArrayList를 생성
    public void generateAllNums(){
        for(int i = 1; i < 46; i++)
            allNums.add(i);
    }

    //6개의 로또 번호를 생성
    public void generateLotto(){
        Collections.shuffle(allNums);
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        for(int j = 0;  j < 6; j++)
            tempList.add(allNums.get(j));
        System.out.println(tempList);
        addLotto(tempList);
    }

    //로또 번호 생성 로직 시작
    public void startGeneration(int jadong, int sudong){
        System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다\n", sudong, jadong);
        for(int i = 0 ; i < jadong; i++){
            generateLotto();
        }
    }
    
}
