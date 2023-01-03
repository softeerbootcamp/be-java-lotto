package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Lotto {

    private ArrayList<ArrayList<Integer>> lottoList = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> allNums = new ArrayList<Integer>();
    private int bonus = 0;

    public Lotto(){
        for(int i = 1; i < 46; i++)
            allNums.add(i);
    }

    //generate random numbers of lottery
    public void addRandomLotto() {
        Collections.shuffle(allNums);
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        for(int j = 0;  j < 6; j++)
            tempList.add(allNums.get(j));
        System.out.println(tempList);
        lottoList.add(tempList);
    }

    //insert number into lotto list
    public void addMyLotto(ArrayList<Integer> lottoNums){
        lottoList.add(lottoNums);
    }

    //getter for the lotto list
    public ArrayList<ArrayList<Integer>> getLottoList(){
        return lottoList;
    }
}
