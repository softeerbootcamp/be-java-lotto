package kr.codesquad.utils;

import kr.codesquad.exception.CustomException;
import kr.codesquad.exception.ErrorCode;

import java.util.ArrayList;

public class Utility {

    public static void checkNumberError(int number){
        if(number < 0) throw new CustomException(ErrorCode.NEGATIVE_NUMBER_ERROR);
        if(number > 45) throw new CustomException(ErrorCode.OUT_OF_RANGE);
    }

    public static void checkAmountOfMoney(int amountOfMoney){
        if(amountOfMoney < 0) throw new CustomException(ErrorCode.NEGATIVE_NUMBER_ERROR);
        else if(amountOfMoney < 1000) throw new CustomException(ErrorCode.MONEY_NOT_ENOUGH);
    }

    public static ArrayList<Integer> checkListContainsNumber(ArrayList<Integer> list,Integer number){
        checkNumberError(number);
        if(list.contains(number)) throw new CustomException(ErrorCode.NUMBER_ALREADY_EXIST);
        list.add(Integer.valueOf(number));
        return list;
    }

    public static ArrayList<ArrayList<Integer>> mergeLists(ArrayList<ArrayList<Integer>> manualLottos, ArrayList<ArrayList<Integer>> lottos){
        manualLottos.addAll(lottos);
        return manualLottos;
    }

    public static  ArrayList<Integer> getListFromInputBySplit(String inputNumbers){
        ArrayList<Integer> resList = new ArrayList<>();
        if(inputNumbers.split(", ").length != 6) throw new CustomException(ErrorCode.ILLEGAL_LOTTO_NUM_COUNT);
        for(String input : inputNumbers.split(", ")){
            resList = checkListContainsNumber(resList,Integer.valueOf(input));
        }
        return resList;
    }
}
