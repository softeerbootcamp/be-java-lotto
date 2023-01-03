package kr.codesquad.InputManager;

import kr.codesquad.Exceptions.CustomException;

import java.util.List;
import java.util.Scanner;

public interface UserInputHandler {
    public  int getOneNumber(int lower_bound, int upper_bound) ;

    public  int getMoney() ;

    public  List<Integer> getSixNumber() ;

    public  int getBonusNumber(List<Integer> winningNumbers) ;
}
