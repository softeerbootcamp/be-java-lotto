package kr.codesquad.generator;

import java.util.ArrayList;
import java.util.Collections;

public class AutoGenerator implements LottoGenerator {

    private ArrayList<Integer> allNums = new ArrayList<Integer>();

    public AutoGenerator(){
        generateAllNums();
    }

    @Override
    public ArrayList<Integer> generateLotto() {
        return startGeneration();
    }

    //난수 생성 용 ArrayList를 생성
    public void generateAllNums(){
        for(int i = 1; i < 46; i++)
            allNums.add(i);
    }

    //6개의 로또 번호를 생성
    public ArrayList<Integer> generateSixNumbers(){
        Collections.shuffle(allNums);
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        for(int j = 0;  j < 6; j++)
            tempList.add(allNums.get(j));
        System.out.println(tempList);
        return tempList;
    }

    //로또 번호 생성 로직 시작
    public ArrayList<Integer> startGeneration(){
        return generateSixNumbers();
    }

}
