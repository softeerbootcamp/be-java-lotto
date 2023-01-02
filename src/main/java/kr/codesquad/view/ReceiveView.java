package kr.codesquad.view;

import java.util.Scanner;

public class ReceiveView {

    public static int EnterPurchaseAmount(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
