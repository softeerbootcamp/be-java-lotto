package kr.codesquad.service.Input;

import java.util.Scanner;

public class ScannerInput {
    Scanner sc;
    public ScannerInput(){
        sc = new Scanner(System.in);
    }
    public int inputNumber() {
        String num = sc.nextLine();
        int intNum = (int)Integer.parseInt(num);
        return intNum;
    }
    public String inputLine() {
        return sc.nextLine();
    }
}
