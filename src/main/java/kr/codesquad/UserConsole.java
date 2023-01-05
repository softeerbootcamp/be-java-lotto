package kr.codesquad;

import kr.codesquad.exception.CustomException;
import kr.codesquad.exception.ErrorCode;
import kr.codesquad.utils.Utility;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserConsole {
    private Scanner sc;

    public UserConsole(){
        sc = new Scanner(System.in);
    }

    public String enter6NumbersByString(){
        String inputNumbers;
        try{
            inputNumbers = sc.nextLine();
        }catch(Exception e){
            throw new CustomException(ErrorCode.ILLEGAL_INPUT_FORMAT);
        }

        return inputNumbers;
    }

    public int enterInteger(){
        int inputNumber=0;
        try{
            inputNumber = sc.nextInt();
            Utility.checkNumberError(inputNumber);
            sc.nextLine();
        }catch(InputMismatchException e){
            System.out.println("정수만 입력 가능합니다");
        }catch(Exception e){
            throw new CustomException(ErrorCode.ILLEGAL_INPUT_FORMAT);
        }
        return inputNumber;
    }


}
