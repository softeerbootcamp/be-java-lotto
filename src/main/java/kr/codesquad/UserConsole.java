package kr.codesquad;

import java.util.Scanner;

public class UserConsole {
    private Scanner sc;

    public UserConsole(){
        sc = new Scanner(System.in);
    }

    public String enter6NumbersByString(){
        String inputNumbers = sc.nextLine();
        return inputNumbers;
    }

    public int enterInteger(){
        int inputNumber = sc.nextInt();
        return inputNumber;
    }


}
