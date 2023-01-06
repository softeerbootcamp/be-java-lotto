package kr.codesquad.Utility;

import kr.codesquad.CustomException;

import java.util.Scanner;

public class InputHandler {

    public int getIntegerInput() throws CustomException {
        try {
            Scanner sc = new Scanner(System.in);
            return sc.nextInt();
        } catch (Exception e) {
            throw new CustomException("입력이 잘못되었습니다!");
        }
    }
    public String getStringInput() throws CustomException {
        try {
            Scanner sc = new Scanner(System.in);
            return sc.nextLine();
        } catch (Exception e) {
            throw new CustomException("입력이 잘못되었습니다!");
        }
    }
}

