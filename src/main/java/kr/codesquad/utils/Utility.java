package kr.codesquad.utils;

import kr.codesquad.exception.CustomException;
import kr.codesquad.exception.ErrorCode;

import java.util.ArrayList;

public class Utility {

    public static  ArrayList<Integer> getListFromInputBySplit(String inputNumbers){
        ArrayList<Integer> resList = new ArrayList<>();
        if(inputNumbers.split(", ").length != 6) throw new CustomException(ErrorCode.ILLEGAL_LOTTO_NUM_COUNT);
        for(String input : inputNumbers.split(", ")){
            resList.add(Integer.valueOf(input));
        }
        return resList;
    }
}
