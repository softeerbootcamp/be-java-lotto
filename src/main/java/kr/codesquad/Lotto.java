package kr.codesquad;

import java.util.ArrayList;
import java.util.Scanner;

public class Lotto {

    private ArrayList<ArrayList<Integer>> lottoList = new ArrayList<ArrayList<Integer>>();
    private static ArrayList<Integer> allNums;

    public Lotto(){
    }

    public void addLotto(ArrayList<Integer> lottoNums){
        lottoList.add(lottoNums);
    }

    public ArrayList<ArrayList<Integer>> getLottoList(){
        return lottoList;
    }
}
