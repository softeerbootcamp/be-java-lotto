package kr.codesquad.Utility;

import kr.codesquad.CustomException;

import java.util.Scanner;

public class InputHandler {

    public int getIntegerInput() {

        Scanner sc = new Scanner(System.in);
        return sc.nextInt();

    }

    public String getStringInput() {

        Scanner sc = new Scanner(System.in);
        return sc.nextLine();

    }
}

